package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정곤이의단조증가하는수 {

	static boolean check(int num) {
		char[] c = String.valueOf(num).toCharArray();
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] > c[i + 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] answers = new int[T];
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			for (int i = n - 1; i > 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					int num = arr[i] * arr[j];
					if (check(num))
						answer = Math.max(answer, num);
				}
			}
			answers[tc] = answer;
		}
		for (int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + answers[i]);
		}
	}
}
