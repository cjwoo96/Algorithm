package swea;

import java.util.Scanner;

public class 원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] answers = new int[T];
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			boolean check = true;
			int answer = 0;
			for (int i = 0; i < str.length(); i++) {
				if (!check && str.charAt(i) == '0') {
					answer++;
					check = true;
				} else if (check && str.charAt(i) == '1') {
					answer++;
					check = false;
				}

			}
			answers[tc] = answer;
		}
		for (int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + answers[i]);
		}
	}
}
