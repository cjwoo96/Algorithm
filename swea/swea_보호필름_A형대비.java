package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름 {

	static int D, W, K;
	static int[][] map, cmap;
	static int[] A, B;
	static int answer;
	static boolean flag;

	static void DFS(int[][] map, int L, int T, int cnt) {
		if (flag)
			return;

		if (cnt == T) {
			if (checking(map)) {
				answer = T;
				flag = true;
			}
		} else if (L == D)
			return;

		else {
			DFS(map, L + 1, T, cnt);
			map[L] = A;
			DFS(map, L + 1, T, cnt + 1);
			map[L] = B;
			DFS(map, L + 1, T, cnt + 1);
			map[L] = cmap[L];

		}
	}

	static boolean checking(int[][] map) {
		L: for (int i = 0; i < W; i++) {
			int cnt = 1;
			int z = -1;
			for (int j = 0; j < D; j++) {
				if (map[j][i] != z) {
					z = map[j][i];
					cnt = 1;
				} else {
					cnt++;
					if (cnt == K)
						continue L;
				}
			}
			if (cnt < K)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			answer = Integer.MAX_VALUE;
			flag = false;
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			cmap = new int[D][W];
			A = new int[W];
			B = new int[W];
			Arrays.fill(A, 1);
			Arrays.fill(B, 0);
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cmap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i <= D; i++) {
				DFS(map, 0, i, 0);
				if (flag)
					break;
			}
			sb.append("#" + (tc + 1) + " " + answer).append("\n");
		}
		System.out.println(sb);

	}
}