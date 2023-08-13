package practice_Git02;

import java.util.Scanner;

public class swea_1954 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i <T; i++) {

			int n = sc.nextInt();
			int sx = 0;
			int sy = 0;
			int idx = 2;

			int[][] arr = new int[n][n];
			arr[0][0] = 1;
			w1: while (true) {
				for (int j = 0; j < 4; j++) {
					int nx = sx + dx[j];
					int ny = sy + dy[j];
					if (nx >= 0 && nx < n & ny >= 0 && ny < n && arr[nx][ny] == 0) {
						sx = nx;
						sy = ny;
						arr[sx][sy] = idx++;
						j--;

					}
					if (idx > n * n)
						break w1;
				}
			}
			sb.append("#"+n+"\n");
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					sb.append(arr[j][k]+" ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}
