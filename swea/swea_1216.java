package Swea;

import java.util.Scanner;

public class _1216 {

	static char[][] map;

	static boolean checking(int lt, int rt) {
		int slt = 0;
		int srt = 0;
		// �� �������� i==0���� 100���� ȸ���� �����ϴ��� Ȯ��
		lb: for (int i = 0; i < 100; i++) {
			slt = lt;
			srt = rt;
			//�糡���� �������鼭 �ϳ��� Ȯ��.
			while (slt < srt) {
				if (map[i][slt] == map[i][srt]) {
					slt++;
					srt--;
				} else
					continue lb;
			}
			// ��� Ȯ�������� �������� �ʴ� �� ���� �� ��ȯ�ϸ� true��ȯ
			return true;
		}

		// ���� ���� ������� i==0���� i==100���� ȸ������ Ȯ��.
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
		// ���� ��ŭ for�� �ݺ�.
		for (int tc = 0; tc < 10; tc++) {
			int n = sc.nextInt();
			// map�迭 ����
			map = new char[100][100];
			// ���� ������ answer ���� �ʱ�ȭ
			int answer = 0;
			// map�迭�� �� �Է�.
			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for (int j = 0; j < 100; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			// i�� ���ڿ��� ���̸� �ǹ�. ���� ū �� ���� �����ϴٰ� �����ϴ°��� ������ break �ϴ� ���� ȿ�����̹Ƿ� ū������ Ȯ���Ѵ�
			f1: for (int i = 99; i >= 1; i--) {
				// i�� Ư�� ������ �϶� �迭�� Ư�� ���̳� ������ Ư�� �������� ���ڿ��� �� �� �� �� �ִ��� ���.
				for (int j = 0; j < 100 - i; j++) {
					// ���ʳ��� ������ �� �� ����
					int lt = j;
					int rt = lt + i;
					// lt�� rt�� �־������� �̸� �����ϴ� ȸ���� ������ true�� ��ȯ�ϹǷ� answer�� ���� �����ϰ� break;
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
