
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class NextNode implements Comparable<NextNode> {
		int Next;
		int value;

		public NextNode(int next, int value) {
			Next = next;
			this.value = value;
		}

		@Override
		public int compareTo(NextNode o) {
			// TODO Auto-generated method stub
			return -o.value + this.value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] NodeValue = new int[N + 1];
			int[] NodeSum = new int[N + 1];
			int[] count = new int[N + 1];
			ArrayList<Integer>[] arr = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				NodeValue[i] = Integer.parseInt(st.nextToken());
				arr[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				count[b]++;
				arr[a].add(b);
			}

			st = new StringTokenizer(br.readLine());
			int targetNode = Integer.parseInt(st.nextToken());
			PriorityQueue<NextNode> Q = new PriorityQueue<>();
			for (int i = 1; i <= N; i++) {
				if (count[i] == 0) {
					NodeSum[i] = NodeValue[i];
					for (int j = 0; j < arr[i].size(); j++) {
						Q.add(new NextNode(arr[i].get(j), NodeSum[i] + NodeValue[arr[i].get(j)]));

					}
				}
			}
			while (!Q.isEmpty()) {
				NextNode k = Q.poll();
				count[k.Next]--;
				if (count[k.Next] != 0)
					continue;
				NodeSum[k.Next] = k.value;
				if (k.Next == targetNode)
					break;
				for (int i = 0; i < arr[k.Next].size(); i++) {
					Q.add(new NextNode(arr[k.Next].get(i), NodeSum[k.Next] + NodeValue[arr[k.Next].get(i)]));
				}
			}
//			for (int k : NodeSum) {
//				System.out.print(k + " ");
//			}
//
//			System.out.println();
//			for (int k : count) {
//				System.out.print(k + " ");
//			}
			sb.append(NodeSum[targetNode]).append("\n");
		}
		System.out.println(sb);

	}
}
