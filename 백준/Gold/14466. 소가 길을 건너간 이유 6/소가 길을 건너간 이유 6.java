
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class point {
		boolean cow = false;
		boolean visited = false;
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		point[][] map = new point[N + 1][N + 1];
		ArrayList<point>[][] road = new ArrayList[N + 1][N + 1];
		boolean[][] visited;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new point(i, j);
			}
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			if (road[sx][sy] == null)
				road[sx][sy] = new ArrayList<>();
			if (road[lx][ly] == null)
				road[lx][ly] = new ArrayList<>();
			// 양방향 다리 건설
			road[sx][sy].add(new point(lx, ly));
			road[lx][ly].add(new point(sx, sy));

		}
		for (int i = 0; i < K; i++) {
			// 소 위치 저장.
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y].cow = true;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j].cow && !map[i][j].visited) {
//					System.out.println("시작 위치  :  " + i + "  " + j);
					int cnt = 1;
					visited = new boolean[N + 1][N + 1];
					map[i][j].visited = true;
					visited[i][j] = true;
					Queue<point> Q = new LinkedList<>();
					Q.add(new point(i, j));
					while (!Q.isEmpty()) {
						point p = Q.poll();
						L: for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if (road[p.x][p.y] != null) {
								for (int v = 0; v < road[p.x][p.y].size(); v++) {
									if (road[p.x][p.y].get(v).x == nx && road[p.x][p.y].get(v).y == ny) {
//										System.out.println("다리에 걸림 -- " + p.x + "," + p.y + "--->" + nx + "," + ny);
										continue L;
									}

								}
							}

							if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && !visited[nx][ny]) {
//								System.out.println("넘어온 좌표 -- " + p.x + "," + p.y + "--->" + nx + "," + ny);
								if (map[nx][ny].cow && !map[nx][ny].visited) {
									map[nx][ny].visited = true;
									cnt++;
//									System.out.println("소 방문 -- " + p.x + "," + p.y + "--->" + nx + "," + ny);
								}
								visited[nx][ny] = true;
								Q.add(new point(nx, ny));

							}
						}
					}
					list.add(cnt);

				}
			}
		}

//		for (int x : list) {
//			System.out.print(x + " ");
//		}

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				sum += list.get(i) * list.get(j);
			}
		}
		System.out.println(sum);
	}
}
// 입력값
//4 5 6
//1 2 1 3
//2 1 3 1
//2 2 2 3
//2 2 3 2
//3 4 4 4
//4 4 4 3
//2 1
//2 2
//2 3
//4 4
//2 4