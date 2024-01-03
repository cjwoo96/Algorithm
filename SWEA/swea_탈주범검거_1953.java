package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {

	static int cnt, N, M, sx, sy, t;
	static int[][] check, map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean canGO(int k, int nk) {
		if (k == 0) {
			if (nk == 1 || nk == 2 || nk == 5 || nk == 6)
				return true;
		} else if (k == 1) {
			if (nk == 1 || nk == 3 || nk == 7 || nk == 6)
				return true;
		} else if (k == 3) {
			if (nk == 1 || nk == 3 || nk == 5 || nk == 4)
				return true;
		} else {
			if (nk == 1 || nk == 2 || nk == 4 || nk == 7)
				return true;
		}
		return false;
	}

	static void BFS() {
		Queue<point> Q = new LinkedList<>();
		check = new int[N][M];
		check[sx][sy] = 1;
		Q.add(new point(sx, sy));
		int time = 1;
		cnt = 1;
		while (!Q.isEmpty()) {
			if (time == t)
				break;
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				point p = Q.poll();
				int mx = p.x;
				int my = p.y;
				int nx;
				int ny;
				if (map[mx][my] == 1) {
					for (int j = 0; j < 4; j++) {
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				} else if (map[mx][my] == 2) {
					for (int j = 0; j < 4; j++) {
						if (j == 1 || j == 3)
							continue;
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				} else if (map[mx][my] == 3) {
					for (int j = 0; j < 4; j++) {
						if (j == 2 || j == 0)
							continue;
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				} else if (map[mx][my] == 4) {
					for (int j = 0; j < 4; j++) {
						if (j == 2 || j == 3)
							continue;
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				} else if (map[mx][my] == 5) {
					for (int j = 0; j < 4; j++) {
						if (j == 0 || j == 3)
							continue;
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				} else if (map[mx][my] == 6) {
					for (int j = 0; j < 4; j++) {
						if (j == 1 || j == 0)
							continue;
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				} else if (map[mx][my] == 7) {
					for (int j = 0; j < 4; j++) {
						if (j == 1 || j == 2)
							continue;
						nx = mx + dx[j];
						ny = my + dy[j];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0 && canGO(j, map[nx][ny])) {
							check[nx][ny] = 1;
							Q.add(new point(nx, ny));
							cnt++;
						}
					}
				}
			}
			time++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			BFS();
			sb.append("#" + (tc + 1) + " " + cnt).append("\n");
		}
		System.out.println(sb);
	}
}
