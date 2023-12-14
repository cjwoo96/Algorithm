
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
		ArrayList<point> list = new ArrayList<>();

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		point[][] map = new point[N + 1][N + 1];

		boolean[][] visited = new boolean[N + 1][N + 1];
		boolean[][] light = new boolean[N + 1][N + 1];
		boolean[][] canGO = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new point(i, j);
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			int p2x = Integer.parseInt(st.nextToken());
			int p2y = Integer.parseInt(st.nextToken());
			map[px][py].list.add(new point(p2x, p2y));
		}
		light[1][1] = true;
		visited[1][1] = true;

		int answer = 1;

		Queue<point> Q = new LinkedList<>();
		Q.add(map[1][1]);
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		while (!Q.isEmpty()) {
			point p = Q.poll();
//			System.out.println("x = " + p.x + " y = " + p.y);
			for (int i = 0; i < p.list.size(); i++) {
				point temp = p.list.get(i);
				if (!light[temp.x][temp.y]) {
					answer++;
					light[temp.x][temp.y] = true;
					if (canGO[temp.x][temp.y]) {
						Q.add(map[temp.x][temp.y]);
						visited[temp.x][temp.y] = true;
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (!(nx >= 1 && nx <= N && ny >= 1 && ny <= N))
					continue;
				canGO[nx][ny] = true;
				if (!visited[nx][ny] && light[nx][ny]) {
					visited[nx][ny] = true;
					Q.add(map[nx][ny]);

				}

			}
		}
		System.out.println(answer);

	}
}
