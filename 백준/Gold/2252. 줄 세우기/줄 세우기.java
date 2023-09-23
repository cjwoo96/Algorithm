

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] Value = new int[N + 1];
		ArrayList<Integer>[] arr = new ArrayList[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (arr[a] == null)
				arr[a] = new ArrayList<Integer>();
			arr[a].add(b);
			Value[b]++;
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (Value[i] == 0)
				Q.add(i);
		}
		while (!Q.isEmpty()) {
			int k = Q.poll();
			sb.append(k + " ");
			if (arr[k] == null)
				continue;
			for (int i = 0; i < arr[k].size(); i++) {
				int temp = arr[k].get(i);
				Value[temp]--;
				if (Value[temp] == 0)
					Q.add(temp);
			}
		}
		System.out.println(sb);
	}

}
