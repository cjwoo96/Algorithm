package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {

	static int day, month, Tmonth, year, answer;
	static int[] plan = new int[13];

	static void DFS(int Month, int sum) {

		if (Month > 12) {
			answer = Math.min(answer, sum);
		} else {
			if (plan[Month] == 0)
				DFS(Month + 1, sum);
			DFS(Month + 1, plan[Month] * day + sum);
			DFS(Month + 1, month + sum);
			DFS(Month + 3, Tmonth + sum);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			Tmonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			DFS(1, 0);
			answer = Math.min(answer, year);
			sb.append("#" + (tc + 1) + " " + answer).append("\n");
		}
		System.out.println(sb);
	}
}
