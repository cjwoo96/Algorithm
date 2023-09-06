package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {

	static int n, B;
	static int[] arr;
	static int answer;

	static void DFS(int sum, int idx) {
		if (sum - B >= answer)
			return;
		if (sum >= B)
			answer = sum - B;
		else {
			for (int i = idx; i < n; i++) {
				DFS(sum + arr[i], i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			DFS(0, 0);
			sb.append("#" + (tc + 1) + " " + answer).append("\n");
		}
		System.out.println(sb);
	}
}
