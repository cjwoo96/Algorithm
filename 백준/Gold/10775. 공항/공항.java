

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int find(int x) {
		if (arr[x] == x)
			return x;
		else
			return arr[x] = find(arr[x]);
	}

	static void Union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if (a1 > b1)
			arr[a1] = b1;
		else
			arr[b1] = a1;
	}

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (find(k) == 0)
				break;
			cnt++;
			Union(k, find(k) - 1);
		}

		System.out.println(cnt);
	}

}
