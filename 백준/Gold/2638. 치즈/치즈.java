
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int[][] map = new int[N][M];

		ArrayList<point> cheeses = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeses.add(new point(i, j));
			}
		}

		Queue<point> Q = new LinkedList<>();
		map[0][0] = 2;
		Q.add(new point(0, 0));

		while (!Q.isEmpty()) {
			point p = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					Q.add(new point(nx, ny));
				}
			}
		}
		int cheeseSize = cheeses.size();
		int cnt = 0;
		int answer = 0;
		while (cheeseSize != cnt) {
			ArrayList<Integer> remove = new ArrayList<Integer>();
			ArrayList<Integer> zero = new ArrayList<Integer>();
			for (int i = 0; i < cheeses.size(); i++) {
				point p = cheeses.get(i);
				boolean flag = false;
				int count = 0;
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (map[nx][ny] == 2) {
						count++;
					}
					if (map[nx][ny] == 0) {
						flag = true;
					}
				}

				if (count >= 2) {
					remove.add(i);
					if (flag)
						zero.add(i);
				}
			}

			cnt += remove.size();
			for (int i = 0; i < zero.size(); i++) {

				Queue<point> q = new LinkedList<>();
				q.add(cheeses.get(zero.get(i)));
				while (!q.isEmpty()) {
					point p = q.poll();
					for (int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (map[nx][ny] == 0) {
							map[nx][ny] = 2;
							q.add(new point(nx, ny));
						}
					}
				}
			}
			for (int i = remove.size() - 1; i >= 0; i--) {
				int idx = remove.get(i);
				map[cheeses.get(idx).x][cheeses.get(idx).y] = 2;
				cheeses.remove(idx);
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println();
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//			}
//			System.out.println();
//			System.out.println("=======================================");

			answer++;
		}
		System.out.println(answer);

	}
}
