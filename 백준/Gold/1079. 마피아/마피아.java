import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, Me;
	static int[][] GiltyMap;
	static int answer = 0;

	static void DFS(int Alive, int NightCnt, int[] gilty, boolean[] dead) {
		if (Alive == 1) {
			answer = Math.max(answer, NightCnt);
			return;
		}

		boolean[] Ndead = new boolean[N];

		for (int i = 0; i < N; i++) {

			Ndead[i] = dead[i];
		}
		// 낮
		if (Alive % 2 == 1) {
			int maxGilty = 0;
			int maxIndex = -1;
//			for (int x : Ngilty) {
//				System.out.print(x);
//			}
//			System.out.println("=================");
//			for (boolean x : Ndead) {
//				System.out.print(x);
//			}
//			System.out.println();
//			System.out.println("=================");
			for (int i = 0; i < N; i++) {
				if (!Ndead[i]) {
					if (maxGilty < gilty[i]) {
						maxGilty = gilty[i];
						maxIndex = i;
					}
				}
			}
			if (maxIndex == Me) {
				answer = Math.max(answer, NightCnt);
				return;
			} else {
				Ndead[maxIndex] = true;
				DFS(Alive - 1, NightCnt, gilty, Ndead);
			}
		} else {
			for (int i = 0; i < N; i++) {
				if (!Ndead[i] && i != Me) {
					Ndead[i] = true;
					for (int j = 0; j < N; j++) {
						if (!Ndead[j]) {
							gilty[j] += GiltyMap[i][j];
						}
					}
					DFS(Alive - 1, NightCnt + 1, gilty, Ndead);

					for (int j = 0; j < N; j++) {
						if (!Ndead[j]) {
							gilty[j] -= GiltyMap[i][j];
						}
					}
					Ndead[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		boolean[] Dead = new boolean[N];
		int[] Gilty = new int[N];
		GiltyMap = new int[N][N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			Gilty[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				GiltyMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		Me = Integer.parseInt(st.nextToken());
		DFS(N, 0, Gilty, Dead);
		System.out.println(answer);
	}
}
