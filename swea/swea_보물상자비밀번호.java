package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 보물상자비밀번호 {

	static int n, k;
	static String str;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			for (int i = 0; i < n / 4; i++) {
				int idx = i;
				for (int j = 0; j < 4; j++) {
					int sum = 0;
					for (int k = n / 4 - 1; k >= 0; k--) {
						int value = 0;
						if (str.charAt(idx) >= 'A')
							value = str.charAt(idx) - 'A' + 10;
						else
							value = value = str.charAt(idx) - '0';
						sum += Math.pow(16, k) * value;
						idx++;
						if (idx == str.length())
							idx = 0;
					}
					if (!list.contains(Integer.valueOf(sum)))
						list.add(sum);
				}
			}
			Collections.sort(list, Comparator.reverseOrder());
			sb.append("#" + (tc + 1) + " " + list.get(k - 1)).append("\n");
		}
		System.out.println(sb);
	}
}
