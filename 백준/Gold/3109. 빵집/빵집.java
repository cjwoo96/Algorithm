
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static int[] dx = { -1, 0, 1 };
	static boolean flag;

	static void DFS(int x, int L) {
		for (int i = 0; i < 3; i++) {
			int nx;
			if (i == 0)
				nx = x - 1;
			else if (i == 1)
				nx = x;
			else
				nx = x + 1;
			if (nx >= 0 && nx < R && map[nx][L + 1] == '.' && !flag) {
				map[nx][L + 1] = 'x';
				if (L + 1 == C - 1) {
					flag = true;
				} else
					DFS(nx, L + 1);
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int answer = 0;
		for (int i = 0; i < R; i++) {
			flag = false;
			DFS(i, 0);
			if (flag)
				answer++;
		}
		System.out.println(answer);

	}
}
