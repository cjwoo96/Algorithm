package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최장경로 {

	static int n, m;
	static int[] check;
	static ArrayList<Integer>[] arr;
	static int answer;

	static void DFS(int L, int k, int sum) {
		if (L == n) {
			answer = L;
		} else {
			for (int i = 1; i <= arr[k].size(); i++) {
				if (check[arr[k].get(i - 1)] == 0) {
					check[arr[k].get(i - 1)] = 1;
					DFS(L + 1, arr[k].get(i - 1), sum + 1);
					check[arr[k].get(i - 1)] = 0;
				}
			}
			answer = Math.max(answer, sum);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new ArrayList[n + 1];
			check = new int[n + 1];
			answer = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			for (int i = 1; i <= n; i++) {
				check[i] = 1;
				DFS(0, i, 1);
				check[i] = 0;
			}
			sb.append("#" + (tc + 1) + " " + answer).append("\n");

		}
		System.out.println(sb);
	}
}
