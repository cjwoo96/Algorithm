

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int answer = Integer.MIN_VALUE;
	static int N, M, R;
	static int[][] arr, copyMap;
	static int[] check;
	static int[] dx = { -1, 0, 0 };
	static int[] dy = { 0, -1, 1 };

	static ArrayList<point> list = new ArrayList<>();

	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this.x == ((point) obj).x && this.y == ((point) obj).y)
				return true;
			return false;
		}
	}

	static point catchZombie(int k) {
		Queue<point> Q = new LinkedList<>();
		Q.add(new point(N - 1, k));
		boolean[][] visit = new boolean[N][M];
		visit[N - 1][k] = true;
		int time = 1;
		point Z = null;
		while (!Q.isEmpty()) {
			if (copyMap[N - 1][k] == 1)
				Z = new point(N - 1, k);
			if (Z != null || time == R)
				break;
			int size = Q.size();

			for (int t = 0; t < size; t++) {
				point p = Q.poll();
				for (int i = 0; i < 3; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (nx <= N - 1 && nx >= N - R && nx >= 0 && ny >= 0 && ny < M && !visit[nx][ny]) {
						if (copyMap[nx][ny] == 1) {
							if (Z == null)
								Z = new point(nx, ny);
							else {
								if (Z.y > ny)
									Z = new point(nx, ny);
							}
						} else {
							Q.add(new point(nx, ny));
							visit[nx][ny] = true;
						}

					}
				}
			}
			time++;
		}
		return Z;
	}

	static void BFS(int[] check) {
		copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = arr[i][j];
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {
				if (check[j] == 1) {
					point np = catchZombie(j);
					if (np == null)
						continue;
					if (list.contains(np))
						continue;
					list.add(np);
				}
			}

			cnt += list.size();

			for (int j = 0; j < list.size(); j++) {
				copyMap[list.get(j).x][list.get(j).y] = 0;
			}

			list.clear();

			for (int j = N - 1; j >= 1; j--) {
				copyMap[j] = copyMap[j - 1];
			}

		}
		answer = Math.max(answer, cnt);
	}

	static void DFS(int L, int idx) {
		if (L == 3) {
			BFS(check);
		} else {
			for (int i = idx; i < M; i++) {
				check[i] = 1;
				DFS(L + 1, i + 1);
				check[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		check = new int[M];
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0, 0);
		System.out.println(answer);
	}
}
