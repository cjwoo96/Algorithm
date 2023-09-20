package Swea;

import java.io.IOException;

public class swea_서로소집합_3289 {
	static int n, m;
	static int[] arr;

	static int find(int a) {
		if (arr[a] == a)
			return a;
		else {

			return arr[a] = find(arr[a]);
		}

	}

	static void union(int a, int b) {
		int a2 = find(a);
		int b2 = find(b);
		if (b2 < a2)
			arr[a2] = b2;
		else
			arr[b2] = a2;
	}

	public static void main(String[] args) throws IOException {

		arr = new int[8];
		for (int i = 1; i <= 7; i++) {
			arr[i] = i;
		}

		union(1, 3);
		union(6, 7);
		union(6, 3);
		find(7);
		for (int x : arr) {
			System.out.print(x + " ");
		}

	}
}
