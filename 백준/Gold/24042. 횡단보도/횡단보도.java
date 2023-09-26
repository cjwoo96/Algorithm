
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class line implements Comparable<line> {
		int NextNode;
		long Time;

		public line(int NextNode, long Time) {
			this.NextNode = NextNode;
			this.Time = Time;
		}

		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return (int) (this.Time - o.Time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] value = new long[N + 1];

		Arrays.fill(value,Long.MAX_VALUE);

		value[1] = 0;

		ArrayList<line>[] arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<line>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(new line(b, i));
			arr[b].add(new line(a, i));
		}

		PriorityQueue<line> Q = new PriorityQueue<line>();

		for (int i = 0; i < arr[1].size(); i++) {
			Q.add(arr[1].get(i));
		}

		ArrayList<line> tempLine = new ArrayList<>();

		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		while (!Q.isEmpty()) {

			line k = Q.poll();

//			System.out.println("다음노드, 시간 " + k.NextNode + " " + k.Time);
			if (visited[k.NextNode])
				continue;
			// 다음 노드로 이동
			// 노드에 도착한 시간 갱신.
			value[k.NextNode] = k.Time + 1;
			visited[k.NextNode] = true;

			int NowNode = k.NextNode;
			// 그 노드에서 갈 수 있는 간선들 확인
//			System.out.println("다음 노드 = " + k.NextNode + "  시간 = " + cnt);
			for (int i = 0; i < arr[NowNode].size(); i++) {
				if (visited[arr[NowNode].get(i).NextNode])
					continue;
				// 간선 하나 뽑기
				line temp = arr[NowNode].get(i);
				// 현재 시각보다 간선에 저장 될 시간이 좀 더 늦을 경우 바로 큐에 넣음
				if (value[NowNode] <= temp.Time) {
					Q.add(temp);

				} else {
					if ((value[NowNode] / M) * M + temp.Time >= value[NowNode])
						Q.add(new line(temp.NextNode, (value[NowNode] / M) * M + temp.Time));
					else
						Q.add(new line(temp.NextNode, ((value[NowNode] / M) + 1) * M + temp.Time));

				}
			}

		}
		System.out.println(value[N]);
	}
}
