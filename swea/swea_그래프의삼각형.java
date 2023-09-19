package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 그래프의삼각형 {

	static int N, M, cnt;
	static int[] check;
	static ArrayList<Integer>[] arr;

	static void DFS(int sidx, int idx, int L) {
		if (L == 2) {
			if (arr[idx].contains(Integer.valueOf(sidx)))
				cnt++;
		} else {
			for (int i = 0; i < arr[idx].size(); i++) {
				if (arr[idx].get(i) > idx) {
					DFS(sidx, arr[idx].get(i), L + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new ArrayList[N + 1];
			check = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			for (int i = 1; i <= N - 2; i++) {
				DFS(i, i, 0);
			}
			sb.append("#" + (tc + 1) + " " + cnt).append("\n");

		}
		System.out.println(sb);
	}
}
