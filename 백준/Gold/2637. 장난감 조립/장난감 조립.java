
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class point {
		int nextNode, value;

		public point(int nextNode, int value) {
			super();
			this.nextNode = nextNode;
			this.value = value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<point>[] arr = new ArrayList[N + 1];
		int[] count = new int[N + 1];
		int[] value = new int[N + 1];
		value[N] = 1;
		boolean[] check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new point(b, c));
			count[b]++;
			check[a] = true;
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0)
				Q.add(i);
		}

		while (!Q.isEmpty()) {
			int k = Q.poll();
			for (int i = 0; i < arr[k].size(); i++) {
				point temp = arr[k].get(i);
				value[temp.nextNode] += temp.value * value[k];
				count[temp.nextNode]--;
				if (count[temp.nextNode] == 0)
					Q.add(temp.nextNode);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (check[i])
				continue;
			sb.append(i + " " + value[i]).append("\n");
		}
		System.out.println(sb);

	}
}
