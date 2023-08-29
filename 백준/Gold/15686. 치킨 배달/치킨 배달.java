

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point_C {
	int x;
	int y;

	public point_C(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M;
	static int[][] map, visit;
	static int[] check;
	static ArrayList<point_C> list = new ArrayList<>();
	static ArrayList<point_C> listH = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static void Answer(int[] check) {
		int sum = 0;
		int[][] cmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < check.length; i++) {
			if (check[i] == 0) {
				cmap[list.get(i).x][list.get(i).y] = 0;
			}
		}

		for (int i = 0; i < listH.size(); i++) {
			Queue<point_C> Q = new LinkedList<>();
			Q.add(listH.get(i));
			visit = new int[N][N];
			visit[listH.get(i).x][listH.get(i).y] = 1;

			L1: while (!Q.isEmpty()) {
				int size = Q.size();
				for (int j = 0; j < size; j++) {
					point_C p = Q.poll();
					for (int k = 0; k < 4; k++) {
						int nx = p.x + dx[k];
						int ny = p.y + dy[k];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] == 0) {
							visit[nx][ny] = 1;
							Q.add(new point_C(nx, ny));
							if (cmap[nx][ny] == 2) {
								sum += Math.abs(listH.get(i).x - nx) + Math.abs(listH.get(i).y - ny);
								break L1;
							}

						}
					}
				}
			}
		}

		answer = Math.min(answer, sum);
	}

	static void SelectChicken(int L, int idx) {
		if (L == M) {
			Answer(check);
		} else {
			for (int i = idx; i < list.size(); i++) {
				check[i] = 1;
				SelectChicken(L + 1, i + 1);
				check[i] = 0;
			}
		}
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
				if (map[i][j] == 2)
					list.add(new point_C(i, j));
				if (map[i][j] == 1)
					listH.add(new point_C(i, j));
			}
		}
		check = new int[list.size()];
		SelectChicken(0, 0);
		System.out.println(answer);

	}
}
