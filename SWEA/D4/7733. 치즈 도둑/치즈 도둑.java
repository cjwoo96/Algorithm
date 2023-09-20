import java.util.Scanner;

public class Solution {
	static int[][] arr; // 치즈
	static int[][] copyArr; // 갉아먹을 치즈
	static int ch; // 치즈 덩어리 개수
	
	// 탐색 위한 델타값 (상 우 하 좌)
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ch = 0; // 치즈덩어리 개수
			int ch_max = -1;
			int N = sc.nextInt(); // 치즈 한 변의 길이
			
			arr = new int[N+2][N+2]; // 원본 치즈, 범위체크 안하려고 +2
			copyArr = new int[N+2][N+2]; 
			int max = -1;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int val = sc.nextInt();
					arr[i][j] = val;
					copyArr[i][j] = val;
					if (val > max) max = val;
				}
			} // 인풋 받기 + 맛 최대값 구하기 끝
			
			// 요정이 먹으면 0으로 치환
			// 맛있는 정도의 최대값만큼만 돈다. = max
			for (int i = 0; i <= max; i++) {
				
				eat(i, copyArr);
				
				// 시작지점 찾기
				// 값이 0이 아닌 곳
				for (int r = 0; r < copyArr.length; r++) {
					for (int c = 0; c < copyArr.length; c++) {
						if (copyArr[r][c] != 0) {
							ch++;
							cnt(r, c);
						}
					}
				}
				
				// 한 바퀴 돌면 치즈 덩어리 수가 최대값인지 먼저 체크
				if (ch > ch_max) ch_max = ch;
				
				// 그리고 다시 원래 상태로 돌리기
				ch = 0;
				
				for (int idx = 0; idx < N+2; idx++) {
					copyArr[idx] = arr[idx].clone();
				} // 원상복구
			}
			
			System.out.printf("#%d %d\n", tc, ch_max);
		}
	}
	
	// 요정이 갉아먹음
	public static void eat(int date, int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] <= date) {
					arr[i][j] = 0;
				}
			}
		}
	}
	
	// 덩어리 카운트
	public static void cnt(int r, int c) {
		copyArr[r][c] = 0; // 방문처리
		
		// 다음 좌표 갈 수 있는지 사방 탐색
		for (int d = 0; d < 4; d++) {
			if (copyArr[r+dr[d]][c+dc[d]] != 0) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				cnt(nr, nc);
			}
		}
	}
}