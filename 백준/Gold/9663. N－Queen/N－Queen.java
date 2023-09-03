

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] check;
	static int answer = 0;
	static int n;

	static void DFS(int L) {
		if (L == n) {
			answer++;
		} else {
			for (int i = 0; i < n; i++) {
				if (check[i] == -1 && checking(L, i)) {
					check[i] = L;
					DFS(L + 1);
					check[i] = -1;
				}
			}
		}
	}

	static boolean checking(int x, int y) {
		for (int i = 1; i <= x; i++) {
			int nx = x - i;
			int ny = y + i;
			if (ny < n) {
				if (check[ny] == nx)
					return false;
			}
		}
		for (int i = 1; i <= x; i++) {
			int nx = x - i;
			int ny = y - i;
			if (ny >= 0) {
				if (check[ny] == nx)
					return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		check = new int[n];
		Arrays.fill(check, -1);
		DFS(0);
		System.out.println(answer);

	}
}
