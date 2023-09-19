package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class point_l {
	int x, y;

	public point_l(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 점심식사시간 {

	static int N;
	static point_l[] door;
	static int[][] map;
	static ArrayList<point_l> list, listd0, listd1;
	static int answer;

	static int nswer(ArrayList<point_l> listd0, ArrayList<point_l> listd1) {
		ArrayList<Integer> pl = new ArrayList<>();
		int Time0 = 0;
		int Time1 = 0;
		for (int i = 0; i < listd0.size(); i++) {
			pl.add(Math.abs(door[0].x - listd0.get(i).x) + Math.abs(door[0].y - listd0.get(i).y));
		}

		Collections.sort(pl);

		for (int i = 0; i < pl.size(); i++) {
			if (i == 3)
				break;
			pl.set(i, pl.get(i) + 1);
		}

		for (int i = 0; i < pl.size(); i++) {
			if (i + 3 < pl.size()) {
				if (pl.get(i + 3) < pl.get(i) + map[door[0].x][door[0].y]) {
					pl.set(i + 3, pl.get(i) + map[door[0].x][door[0].y]);
				} else
					pl.set(i + 3, pl.get(i + 3) + 1);
			} else
				break;
		}

		if (pl.size() != 0) {
			Time0 = pl.get(pl.size() - 1) + map[door[0].x][door[0].y];
		}

		pl.clear();
		for (int i = 0; i < listd1.size(); i++) {
			pl.add(Math.abs(door[1].x - listd1.get(i).x) + Math.abs(door[1].y - listd1.get(i).y));
		}
		Collections.sort(pl);

		for (int i = 0; i < pl.size(); i++) {
			if (i == 3)
				break;
			pl.set(i, pl.get(i) + 1);
		}

		for (int i = 0; i < pl.size(); i++) {
			if (i + 3 < pl.size()) {
				if (pl.get(i + 3) < pl.get(i) + map[door[1].x][door[1].y]) {
					pl.set(i + 3, pl.get(i) + map[door[1].x][door[1].y]);
				} else
					pl.set(i + 3, pl.get(i + 3) + 1);

			} else
				break;
		}
		if (pl.size() != 0) {
			Time1 = pl.get(pl.size() - 1) + map[door[1].x][door[1].y];
		}

		return Math.max(Time1, Time0);
	}

	static void BS(int L, int[] check) {
		if (L == list.size()) {
			listd0 = new ArrayList<>();
			listd1 = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (check[i] == 0)
					listd0.add(list.get(i));
				else
					listd1.add(list.get(i));
			}
			answer = Math.min(answer, nswer(listd0, listd1));

		} else {
			BS(L + 1, check);
			check[L] = 1;
			BS(L + 1, check);
			check[L] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			N = Integer.parseInt(st.nextToken());
			door = new point_l[2];
			int idx = 0;
			answer = Integer.MAX_VALUE;
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						list.add(new point_l(i, j));
					else if (map[i][j] != 0) {
						door[idx++] = new point_l(i, j);
					}

				}
			}

			int[] check = new int[list.size()];
			BS(0, check);
			sb.append("#" + (tc + 1) + " " + answer).append("\n");
		}
		System.out.println(sb);
	}
}
