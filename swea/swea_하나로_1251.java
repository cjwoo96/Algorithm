package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class line implements Comparable<line> {
	int from, to;
	double we;

	public line(int from, int to, double we) {
		this.from = from;
		this.to = to;
		this.we = we;
	}

	@Override
	public int compareTo(line o) {
		return (int) (this.we - o.we);
	}
}

public class swea_하나로_1251 {

	static int n;
	static double answer, E;
	static int[] S;
	static int[][] arr;
	static ArrayList<line> list;

	static int find(int x) {
		if (S[x] == x)
			return x;
		else {

			return S[x] = find(S[x]);
		}
	}

	static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if (a1 > b1)
			S[a1] = b1;
		else
			S[b1] = a1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[2][n];
			S = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				S[i] = i;
			}
			list = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double ds = Math.pow(arr[0][i] - arr[0][j], 2) + Math.pow(arr[1][i] - arr[1][j], 2);
					list.add(new line(i, j, ds));
				}
			}

			answer = 0;
			Collections.sort(list);
			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (find(list.get(i).to) != find(list.get(i).from)) {
					cnt++;
					union(list.get(i).to, list.get(i).from);
					answer += list.get(i).we * E;
				}
				if (cnt == n - 1)
					break;
			}
			sb.append("#" + (tc + 1) + " " + String.format("%.0f", answer)).append("\n");
		}

		System.out.println(sb);
	}
}
