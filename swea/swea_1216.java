package Swea;

import java.util.Scanner;

public class _1216 {

	static char[][] map;

	static boolean checking(int lt, int rt) {
		int slt = 0;
		int srt = 0;
		// 행 방향으로 i==0부터 100까지 회문을 성립하는지 확인
		lb: for (int i = 0; i < 100; i++) {
			slt = lt;
			srt = rt;
			//양끝에서 좁혀오면서 하나씩 확인.
			while (slt < srt) {
				if (map[i][slt] == map[i][srt]) {
					slt++;
					srt--;
				} else
					continue lb;
			}
			// 모두 확인했을때 만족하지 않는 것 없이 다 순환하면 true반환
			return true;
		}

		// 위와 같은 방식으로 i==0부터 i==100까지 회문인지 확인.
		db: for (int i = 0; i < 100; i++) {
			slt = lt;
			srt = rt;
			while (slt < srt) {
				if (map[slt][i] == map[srt][i]) {
					slt++;
					srt--;
				} else
					continue db;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] answers = new int[10];
		// 테케 만큼 for문 반복.
		for (int tc = 0; tc < 10; tc++) {
			int n = sc.nextInt();
			// map배열 선언
			map = new char[100][100];
			// 값을 저장할 answer 변수 초기화
			int answer = 0;
			// map배열에 값 입력.
			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			// i는 문자열의 길이를 의미. 가장 큰 수 부터 시작하다가 만족하는것이 있으면 break 하는 것이 효율적이므로 큰수부터 확인한다
			f1: for (int i = 99; i >= 1; i--) {
				// i가 특정 사이즈 일때 배열의 특정 행이나 열에서 특정 사이즈의 문자열이 몇 개 들어갈 수 있는지 계산.
				for (int j = 0; j < 100 - i; j++) {
					// 왼쪽끝값 오른쪽 끝 값 선언
					int lt = j;
					int rt = lt + i;
					// lt와 rt가 주어졌을떄 이를 만족하는 회문이 있으면 true를 반환하므로 answer에 길이 저장하고 break;
					if (checking(lt, rt)) {
						answer = i + 1;
						break f1;
					}
				}
			}
			answers[tc] = answer;

		}
		for (int i = 0; i < 10; i++) {
			System.out.println("#" + (i + 1) + " " + answers[i]);
		}

	}
}
