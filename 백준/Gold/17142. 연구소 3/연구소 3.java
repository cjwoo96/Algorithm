

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point2 {
	int x, y;

	public point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M;

	static int[][] map;
	static int Zero = 0;
	static ArrayList<point2> list = new ArrayList<>();
	static int[] check;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void Select(int L, int idx) {
		if (L == M) {
			answer = Math.min(answer, infest(check));
		} else {
			for (int i = idx; i < list.size(); i++) {
				check[i] = 1;
				Select(L + 1, i + 1);
				check[i] = 0;
			}
		}
	}

	static int infest(int[] check) {
		int answer = 0;
		int cnt = 0;
		Queue<point2> Q = new LinkedList<>();
		int[][] cmap = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (check[i] == 1) {
				cmap[list.get(i).x][list.get(i).y] = 1;
				Q.add(list.get(i));
			}
		}
		while (!Q.isEmpty()) {
			int size = Q.size();
			answer++;
			for (int i = 0; i < size; i++) {
				point2 p = Q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && cmap[nx][ny] != 1) {
						if (cmap[nx][ny] == 0) {
							cnt++;
							Q.add(new point2(nx, ny));
						} else {
							Q.add(new point2(nx, ny));
						}
						cmap[nx][ny] = 1;
						if (cnt == Zero)
							return answer;
					}
				}
			}
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					Zero++;
				else if (map[i][j] == 2)
					list.add(new point2(i, j));
			}
		}
		check = new int[list.size()];
		if (Zero == 0)
			answer = 0;
		Select(0, 0);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}
