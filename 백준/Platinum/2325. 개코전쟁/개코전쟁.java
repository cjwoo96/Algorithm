
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class line implements Comparable<line> {
		int nowNode, nextNode, value;

		public line(int nowNode, int nextNode, int value) {
			super();
			this.nowNode = nowNode;
			this.nextNode = nextNode;
			this.value = value;
		}

		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<line>[] arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new line(a, b, c));
			arr[b].add(new line(b, a, c));
		}

		PriorityQueue<line> pq = new PriorityQueue<>();

		for (int i = 0; i < arr[1].size(); i++) {
			pq.add(arr[1].get(i));
		}

		boolean[] visited = new boolean[N + 1];

		int[] ComeFrom = new int[N + 1];

		visited[1] = true;

		while (!pq.isEmpty()) {
			line L = pq.poll();

			if (visited[L.nextNode])
				continue;
			visited[L.nextNode] = true;
			ComeFrom[L.nextNode] = L.nowNode;
			if (L.nextNode == N)
				break;

			for (int i = 0; i < arr[L.nextNode].size(); i++) {
				line temp = arr[L.nextNode].get(i);
				if (visited[temp.nextNode])
					continue;
				pq.add(new line(temp.nowNode, temp.nextNode, temp.value + L.value));
			}

		}

		int n = N;

		int answer = 0;

		while (true) {

			if (n == 1)
				break;
			pq.clear();

			for (int i = 0; i < arr[1].size(); i++) {
				pq.add(arr[1].get(i));
			}

			visited = new boolean[N + 1];

			visited[1] = true;

			while (!pq.isEmpty()) {
				line L = pq.poll();

				if (visited[L.nextNode] || L.nowNode == n && L.nextNode == ComeFrom[n]
						|| L.nextNode == n && L.nowNode == ComeFrom[n])
					continue;

				visited[L.nextNode] = true;

				if (L.nextNode == N) {
					answer = Math.max(answer, L.value);
					break;
				}

				for (int i = 0; i < arr[L.nextNode].size(); i++) {
					line temp = arr[L.nextNode].get(i);
					if (visited[temp.nextNode] || (temp.nowNode == n && temp.nextNode == ComeFrom[n])
							|| (temp.nextNode == n && temp.nowNode == ComeFrom[n]))
						continue;
					pq.add(new line(temp.nowNode, temp.nextNode, temp.value + L.value));
				}

			}

			n = ComeFrom[n];

		}

		System.out.println(answer);
	}
}
