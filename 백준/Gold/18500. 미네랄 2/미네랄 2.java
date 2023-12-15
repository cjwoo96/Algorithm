
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class point implements Comparable<point> {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(point o) {
			return o.x - this.x;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] visited;
		char[][] map = new char[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] attack = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			attack[i] = Integer.parseInt(st.nextToken());
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		L: for (int i = 0; i < N; i++) {
			int h = R - attack[i];

			for (int j = 0; j < C; j++) {
				int nj;
				if (i % 2 == 0)
					nj = j;
				else
					nj = C - 1 - j;
				if (map[h][nj] == 'x') {
					map[h][nj] = '.';
					int sx = h;
					int sy = nj;
					L2: for (int k = 0; k < 4; k++) {
						if (i % 2 == 0 && k == 3)
							continue;
						if (i % 2 == 1 && k == 2)
							continue;

						int nx = sx + dx[k];
						int ny = sy + dy[k];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 'x') {
							if (nx == R - 1)
								continue L;
							Queue<point> Q = new LinkedList<>();
							PriorityQueue<point> pq = new PriorityQueue<>();
							pq.add(new point(nx, ny));
							visited = new boolean[R][C];
							visited[nx][ny] = true;
							Q.add(new point(nx, ny));
							while (!Q.isEmpty()) {

								point p = Q.poll();
								for (int l = 0; l < 4; l++) {
									int xn = p.x + dx[l];
									int yn = p.y + dy[l];
									if (xn >= 0 && xn < R && yn >= 0 && yn < C && !visited[xn][yn]
											&& map[xn][yn] == 'x') {
										if (xn == R - 1)
											continue L2;
										visited[xn][yn] = true;
										Q.add(new point(xn, yn));
										pq.add(new point(xn, yn));
									}
								}
							}
							for (point p : pq) {
								map[p.x][p.y] = '.';
							}
							ArrayList<point> list = new ArrayList<>();
							boolean flag = false;
							while (!flag) {
								int size = pq.size();
								for (int l = 0; l < size; l++) {

									point p = pq.poll();
									int pnx = p.x;
									pnx++;

									if (pnx == R || map[pnx][p.y] == 'x') {
										flag = true;
									}
									list.add(new point(pnx, p.y));
								}
								for (point p : list) {
									pq.add(p);
								}
								list.clear();
							}
							for (point p : pq) {
								map[p.x - 1][p.y] = 'x';
							}
						}
					}
					break;
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {

			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
//				System.out.print(map[i][j]);
			}
//			System.out.println();
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
