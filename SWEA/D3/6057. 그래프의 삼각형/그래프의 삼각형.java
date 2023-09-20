import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 정점개수
			int M = sc.nextInt(); // 간선개수
			
			int[][] arr = new int[N][N]; 
			
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a-1][b-1] = 1;
				arr[b-1][a-1] = 1;
			} // 인접행렬 받기 끝
			
			int cnt = 0; // 삼각형의 개수
			
			// i번째 정점에 연결된 정점들을 보면서, 2개씩 조합
			// 2개의 점을 x,y 라고 하면 arr[x][y] == 1 이면 삼각형 성립
			// 다 돈 다음에 3으로 나눈다(똑같은 삼각형 3개씩 만들어지니까)
			int x, y;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						x = j;
						for (int k = x; k < N; k++) {
							if (arr[i][k] == 1) {
								y = k;
								if (arr[x][y] == 1) {
									cnt++;
								}
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt/3);
		}
	}
}
