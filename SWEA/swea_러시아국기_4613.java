package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] answers = new int[T];
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			char[][] arr = new char[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int answer = Integer.MAX_VALUE;
			int sum = 0;
			// i는 size
			for (int i = 1; i <= N - 2; i++) {
				// B의 시작 칸
				for (int j = 1; j < N - i; j++) {
					sum = 0;
					for (int k = 0; k < j; k++) {
						for (int l = 0; l < M; l++) {
							if (arr[k][l] != 'W')
								sum++;
						}
					}
					for (int k = j; k <= j + i - 1; k++) {
						for (int l = 0; l < M; l++) {
							if (arr[k][l] != 'B')
								sum++;
						}
					}
					for (int k = j + i; k <= N - 1; k++) {
						for (int l = 0; l < M; l++) {
							if (arr[k][l] != 'R')
								sum++;
						}
					}
					answer = Math.min(answer, sum);
				}
			}
			answers[tc] = answer;

		}
		for (int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + answers[i]);
		}
	}
}
