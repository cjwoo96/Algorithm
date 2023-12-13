
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		ArrayList<Integer> sub = new ArrayList<Integer>();
		ArrayList<Integer> Main = new ArrayList<Integer>();
		boolean[] check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			if (check[i])
				continue;
			int temp = i;
			sub.add(temp);
			while (true) {
				temp = arr[temp];
				if (temp == i) {
					for (Integer x : sub) {
						Main.add(x);
						check[x] = true;

					}
					sub.clear();
					break;
				}
				if (sub.contains(temp)) {
					sub.clear();
					break;
				}
				sub.add(temp);

			}
		}
		Collections.sort(Main);
		StringBuilder sb = new StringBuilder();
		sb.append(Main.size()).append("\n");
		for (int x : Main) {
			sb.append(x).append("\n");
		}
		System.out.println(sb);
//		System.out.println(Main.size());
//		for (int x : Main) {
//			System.out.println(x);
//		}
	}

}
