package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class swea_창용마을무리의개수_7465 {

	static int n, m;
	static int[] arr;

	static int find(int x) {
		if (arr[x] == x)
			return x;
		else
			return find(arr[x]);
	}

	static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if (a1 > b1)
			arr[a1] = b1;
		else
			arr[b1] = a1;
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

			arr = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			HashSet<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				set.add(find(i));
			}
			sb.append("#" + (tc + 1) + " " + set.size()).append("\n");

		}
		System.out.println(sb);
	}
}
