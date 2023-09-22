
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static String s1, s2;
	static int N, max;
	static int[] arr, value;

	static int find(int x) {
		if (arr[x] == x)
			return x;
		return arr[x] = find(arr[x]);
	}

	static void union(int a, int b) {
		int a1 = find(a);
		int b1 = find(b);
		if (a1 > b1)
			arr[a1] = b1;
		else
			arr[b1] = a1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {

			HashMap<String, Integer> hMap = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			arr = new int[1000010];
			value = new int[1000010];

			Arrays.fill(value, 1);

			max = 1;
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				s1 = st.nextToken();
				s2 = st.nextToken();

				if (!hMap.containsKey(s1) && !hMap.containsKey(s2)) {

					hMap.put(s1, hMap.size());
					hMap.put(s2, hMap.size());

					arr[hMap.get(s1)] = hMap.get(s1);
					arr[hMap.get(s2)] = hMap.get(s2);

					union(hMap.get(s1), hMap.get(s2));

					value[find(hMap.get(s1))]++;

					max = value[find(hMap.get(s1))];

				} else if (hMap.containsKey(s1) && !hMap.containsKey(s2)) {
					hMap.put(s2, hMap.size());

					arr[hMap.get(s2)] = hMap.get(s2);

					union(hMap.get(s1), hMap.get(s2));

					value[find(hMap.get(s1))]++;

					max = value[find(hMap.get(s1))];
				} else if (!hMap.containsKey(s1) && hMap.containsKey(s2)) {
					hMap.put(s1, hMap.size());
					arr[hMap.get(s1)] = hMap.get(s1);
					union(hMap.get(s1), hMap.get(s2));
					value[find(hMap.get(s1))]++;

					max = value[find(hMap.get(s1))];
				} else {
					if (find(hMap.get(s1)) != find(hMap.get(s2))) {
						int sum = value[find(hMap.get(s1))] + value[find(hMap.get(s2))];
						union(hMap.get(s1), hMap.get(s2));
						value[find(hMap.get(s1))] = sum;
						max = value[find(hMap.get(s1))];
					} else
						max = value[find(hMap.get(s1))];
				}
				sb.append(max).append("\n");
			}
		}
		System.out.println(sb);
	}
}
