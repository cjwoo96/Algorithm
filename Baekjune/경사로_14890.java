// 경사로 골3
package Baekjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {
	static int N, L;
	static int[][] map;
	static int answer = 0;

	// 오른쪽 방향으로 지나갈 수 있는 길인지 체크하는 메서드. 행을 입력받는다.
	static int Rcheck(int x) {
		// 경사로가 놓인자리는 중복해서 경사로가 놓일 수 없으므로 이미 경사로가 건설됨을 체크하는 체크배열
		int[] check = new int[N];
		// i인덱스 와 i+1인덱스 위치의 값 차이가 있는 지점만 확인 할 것이므로 N-2까지만 순회한다.
		for (int i = 0; i < N - 1; i++) {
			// i번과 i+1번 인덱스의 map배열의 값이 다를때 경사로 건설이 가능한지 확인
			if (map[x][i] != map[x][i + 1]) {
				// 두 지점차이가 1보다 크면 경사로 설치x 0을 리턴
				if (Math.abs(map[x][i] - map[x][i + 1]) > 1)
					return 0;
				// 왼쪽방향의 높이가 더 높은 경우.
				else if (map[x][i] > map[x][i + 1]) {
					// 오른쪽방향으로 가는 내리막길을 설치해야하므로 i+1부터 i+L까지 평평한지, 그리고 경사로가 이미 설치되어 있지 않은지, 2차원배열을
					// 벗어나지 않았는지 확인
					for (int j = i + 1; j <= i + L; j++) {
						// map을 벗어났거나, 평평하지 않거나, 이미 경사로가 있는 경우 0을 리턴
						if (j == N || map[x][j] != map[x][i + 1] || check[j] == 1)
							return 0;
						// 경사로 건설했다는 의미로 check배열에 1 넣어줌
						else
							check[j] = 1;
					}
					// 오른쪽 방향의 높이가 높은 경우.
				} else {
					// 오른쪽방향부터 오르막길을 설치해하므로 i-L+1 ~ i까지 탐색
					for (int j = i - L + 1; j <= i; j++) {
						// map을 벗어나거나 평평하지 않거나 이미 경사로가 있으면 0리턴
						if (j < 0 || map[x][i] != map[x][j] || check[j] == 1)
							return 0;
						// 경사로 건설
						else
							check[j] = 1;
					}
				}
			}
		}

		// 모두 확인했는데 건너지 못할 요소가 없으면 1리턴
		return 1;
	}

	// 오른쪽 방향 메소드와 같은 로직으로 구현
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

		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 2차원 배열 map에 입력.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// i=0 ~ N-1까지 가로, 아래 방향으로 지나갈 수 있는지 확인하며 answer에 더해준다.
		for (int i = 0; i < N; i++) {
			answer += Dcheck(i) + Rcheck(i);
		}
		System.out.println(answer);
	}
}
