
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int sx, sy, n, lx, ly;
	static point[] map;
	static boolean[] visited;

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int Distance(int x1, int y1, int x2, int y2) {

		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static boolean BFS() {
		Queue<point> Q = new LinkedList<>();
		Q.add(new point(sx, sy));
		while (!Q.isEmpty()) {
			point p = Q.poll();

			if (Distance(lx, ly, p.x, p.y) <= 1000)
				return true;
			for (int i = 0; i < map.length; i++) {
				if (visited[i])
					continue;
				if (Distance(p.x, p.y, map[i].x, map[i].y) <= 1000) {
					visited[i] = true;
					Q.add(new point(map[i].x, map[i].y));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new point[n];
			visited = new boolean[n];
			st = new StringTokenizer(br.readLine());

			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				map[i] = new point(x1, y1);
			}
			st = new StringTokenizer(br.readLine());
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			if ((sx == lx && sy == ly) || BFS())
				sb.append("happy").append("\n");
			else
				sb.append("sad").append("\n");
		}
		System.out.println(sb);
	}
}
