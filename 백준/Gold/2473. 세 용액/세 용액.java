

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static long answer = Long.MAX_VALUE;
	static int Rlt, Rrt, Rmid;

	static void Search(int i, int j) {
		long sum = arr[i] + arr[j];
		int lt = i + 1;
		int rt = j - 1;
		int mid = 0;
		while (lt <= rt) {
			mid = (lt + rt) / 2;
			if (Math.abs(sum + arr[mid]) < answer) {
				answer = Math.abs(sum + arr[mid]);
				Rlt = i;
				Rrt = j;
				Rmid = mid;
			}

			if (sum + arr[mid] > 0) {
				rt = mid - 1;
			} else
				lt = mid + 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			for (int j = i + 2; j < N; j++) {
				Search(i, j);
				if (answer == 0)
					break;
			}
		}

		System.out.println(arr[Rlt] + " " + arr[Rmid] + " " + arr[Rrt]);
	}
}
