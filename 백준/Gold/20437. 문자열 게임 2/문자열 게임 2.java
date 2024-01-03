
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] arr = new ArrayList[26];

			for (int j = 0; j < 26; j++) {
				arr[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j < str.length(); j++) {
				char temp = str.charAt(j);
				arr[temp - 'a'].add(j);
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 26; j++) {
				if (arr[j].size() < N)
					continue;
				for (int k = 0; k < arr[j].size(); k++) {
					if (k + N - 1 == arr[j].size())
						break;
					int m = arr[j].get(k + N - 1) - arr[j].get(k) + 1;
					max = Math.max(max, m);
					min = Math.min(min, m);
				}
			}
			if (max == Integer.MIN_VALUE)
				sb.append(-1).append("\n");
			else
				sb.append(min + " " + max).append("\n");

		}
		System.out.println(sb);

	}
}
