
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -1, 1, 0, 0, 2, 1, -1, -2, -2, -1, 1, 2 };
	static int answer = 0;

	static void BFS() {
		Queue<point> Q = new LinkedList<>();
		Q.add(new point(0, 0, 0));
		visited[0][0][0] = true;
		while (!Q.isEmpty()) {

			int size = Q.size();
			answer++;
			L: for (int i = 0; i < size; i++) {
				point p = Q.poll();
				for (int j = 0; j < 12; j++) {

					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1)
						continue;
					if (j >= 4) {
						if (p.jump == K)
							continue L;

						else {
							if (!visited[nx][ny][p.jump + 1]) {

								if (nx == H - 1 && ny == W - 1) {
									System.out.println(answer);
									System.exit(0);
								}
								visited[nx][ny][p.jump + 1] = true;
								Q.add(new point(nx, ny, (p.jump + 1)));

							}
						}
					} else {
						if (!visited[nx][ny][p.jump]) {
							if (nx == H - 1 && ny == W - 1) {
								System.out.println(answer);
								System.exit(0);
							}
							visited[nx][ny][p.jump] = true;
							Q.add(new point(nx, ny, p.jump));
						}
					}
				}
			}

		}

	}

	static class point {
		int x, y, jump;

		public point(int x, int y, int jump) {
			super();
			this.x = x;
			this.y = y;
			this.jump = jump;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (W == 1 && H == 1) {
			System.out.println(0);
			System.exit(0);
		}
		BFS();
		System.out.println(-1);
	}
}
