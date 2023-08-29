// 경사로 골3


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] map;
	static int answer = 0;

	static int Rcheck(int x) {
		int[] check = new int[N];
		for (int i = 0; i < N - 1; i++) {
			if (map[x][i] != map[x][i + 1]) {
				if (map[x][i] - map[x][i + 1] > 1)
					return 0;
				else if (map[x][i] > map[x][i + 1]) {
					for (int j = i + 1; j <= i + L; j++) {
						if (j == N || map[x][j] != map[x][i + 1] || check[j] == 1)
							return 0;
						else
							check[j] = 1;
					}
				} else {
					for (int j = i - L + 1; j <= i; j++) {
						if (j < 0 || map[x][i] != map[x][j] || check[j] == 1)
							return 0;
						else
							check[j] = 1;
					}
				}
			}
		}

//		System.out.println("R : x = " + x);
		return 1;
	}

	static int Dcheck(int x) {
		int[] check = new int[N];
		for (int i = 0; i < N - 1; i++) {
			if (map[i][x] != map[i + 1][x]) {
				if (Math.abs(map[i][x] - map[i + 1][x]) > 1)
					return 0;
				else if (map[i][x] > map[i + 1][x]) {
					for (int j = i + 1; j <= i + L; j++) {
						if (j >= N || map[j][x] != map[i + 1][x] || check[j] == 1)
							return 0;
						else
							check[j] = 1;
					}
				} else {
					for (int j = i - L + 1; j <= i; j++) {
						if (j < 0 || map[i][x] != map[j][x] || check[j] == 1)
							return 0;
						else
							check[j] = 1;
					}
				}
			}
		}
//		System.out.println("D : x = " + x);
		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			answer += Dcheck(i) + Rcheck(i);
		}
		System.out.println(answer);
	}
}
