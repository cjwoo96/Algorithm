package Baekjune;

import java.util.Scanner;

public class 사다리조작_15684 {

	static int[][] arr;
	static int N, M, H;

	static void DFS(int Answer, int L) {
		if (L == Answer) {
			if (check()) {
				System.out.println(Answer);
				System.exit(0);
			}
		} else {
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= N - 1; j++) {
					if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
						arr[i][j] = 1;
						arr[i][j + 1] = -1;
						DFS(Answer, L + 1);
						arr[i][j] = 0;
						arr[i][j + 1] = 0;
					}
				}
			}
		}
	}

	static boolean check() {
		for (int i = 1; i <= N; i++) {
			int cnt = i;
			for (int j = 1; j <= H; j++) {
				if (arr[j][cnt] == 1)
					cnt++;
				else if (arr[j][cnt] == -1)
					cnt--;

			}
			if (i != cnt)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();

		arr = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[a][b + 1] = -1;
		}

		for (int Answer = 0; Answer <= 3; Answer++) {
			DFS(Answer, 0);
		}
		System.out.println(-1);
	}

}
