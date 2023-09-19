package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point implements Comparable<point> {
	// 각각 좌표와 값
	int x, y, v;

	public point(int x, int y, int v) {
		this.x = x;
		this.y = y;
		this.v = v;
	}

	// 값이 작은 순으로 정렬
	@Override
	public int compareTo(point o) {
		if (this.v < o.v)
			return -1;
		else
			return 1;
	}

}

public class 치즈도둑 {

	static int N, answer;
	static int[][] map, check;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static ArrayList<point> list;

	static int BFS() {
		Queue<point> Q = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && check[i][j] == 0) {
					cnt++;
					check[i][j] = 1;
					Q.add(new point(i, j, 0));
					while (!Q.isEmpty()) {
						point p = Q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0 && check[nx][ny] == 0) {
								check[nx][ny] = 1;
								Q.add(new point(nx, ny, 0));
							}
						}
					}
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			answer = 1;
			map = new int[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					// 포인트의 좌표와 값 저장.
					list.add(new point(i, j, Integer.parseInt(st.nextToken())));
				}
			}
			// 값이 작은 순서로 list 정렬
			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				// i번째와 i+1번째가 같은 값이면 같은 값들은 모두 먹고 BFS를 돌려야 되므로 넘어감.
				if (i != list.size() - 1 && list.get(i).v == list.get(i + 1).v) {
					map[list.get(i).x][list.get(i).y] = 1;
				} else {
					map[list.get(i).x][list.get(i).y] = 1;
					check = new int[N][N];
					answer = Math.max(answer, BFS());
				}
			}

			sb.append("#" + (tc + 1) + " " + answer).append("\n");

		}
		System.out.println(sb);

	}
}
