import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N + 1];
		int[][] map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int[] check = new int[M];

		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		visited[check[0]] = true;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(check[0]);
		while (!Q.isEmpty()) {
			int k = Q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[k][i] == 0 || visited[i])
					continue;
				int temp = i;
				Q.add(i);
				visited[i] = true;
			}
		}
		boolean answer = false;
		for (int k : check) {
			if (!visited[k]) {
				answer = true;
				break;
			}
		}
		if (answer)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
