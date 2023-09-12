
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int answer = Integer.MAX_VALUE;

	static void TwoPoint(int i, int j) {
		int lt = i + 1;
		int rt = j - 1;
		int sum = arr[i] + arr[j];
		while (lt < rt) {
			if (Math.abs(arr[lt] + arr[rt] - sum) < answer)
				answer = Math.abs(arr[lt] + arr[rt] - sum);
			if (arr[lt] + arr[rt] > sum) {
				rt--;
			} else if (arr[lt] + arr[rt] < sum)
				lt++;
			else
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			for (int j = i + 3; j < N; j++) {
				TwoPoint(i, j);
				if (answer == 0)
					break;
			}
		}
		System.out.println(answer);

	}
}
