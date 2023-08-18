// ���� ��3
package Baekjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_14890 {
	static int N, L;
	static int[][] map;
	static int answer = 0;

	// ������ �������� ������ �� �ִ� ������ üũ�ϴ� �޼���. ���� �Է¹޴´�.
	static int Rcheck(int x) {
		// ���ΰ� �����ڸ��� �ߺ��ؼ� ���ΰ� ���� �� �����Ƿ� �̹� ���ΰ� �Ǽ����� üũ�ϴ� üũ�迭
		int[] check = new int[N];
		// i�ε��� �� i+1�ε��� ��ġ�� �� ���̰� �ִ� ������ Ȯ�� �� ���̹Ƿ� N-2������ ��ȸ�Ѵ�.
		for (int i = 0; i < N - 1; i++) {
			// i���� i+1�� �ε����� map�迭�� ���� �ٸ��� ���� �Ǽ��� �������� Ȯ��
			if (map[x][i] != map[x][i + 1]) {
				// �� �������̰� 1���� ũ�� ���� ��ġx 0�� ����
				if (Math.abs(map[x][i] - map[x][i + 1]) > 1)
					return 0;
				// ���ʹ����� ���̰� �� ���� ���.
				else if (map[x][i] > map[x][i + 1]) {
					// �����ʹ������� ���� ���������� ��ġ�ؾ��ϹǷ� i+1���� i+L���� ��������, �׸��� ���ΰ� �̹� ��ġ�Ǿ� ���� ������, 2�����迭��
					// ����� �ʾҴ��� Ȯ��
					for (int j = i + 1; j <= i + L; j++) {
						// map�� ����ų�, �������� �ʰų�, �̹� ���ΰ� �ִ� ��� 0�� ����
						if (j == N || map[x][j] != map[x][i + 1] || check[j] == 1)
							return 0;
						// ���� �Ǽ��ߴٴ� �ǹ̷� check�迭�� 1 �־���
						else
							check[j] = 1;
					}
					// ������ ������ ���̰� ���� ���.
				} else {
					// �����ʹ������ ���������� ��ġ���ϹǷ� i-L+1 ~ i���� Ž��
					for (int j = i - L + 1; j <= i; j++) {
						// map�� ����ų� �������� �ʰų� �̹� ���ΰ� ������ 0����
						if (j < 0 || map[x][i] != map[x][j] || check[j] == 1)
							return 0;
						// ���� �Ǽ�
						else
							check[j] = 1;
					}
				}
			}
		}

		// ��� Ȯ���ߴµ� �ǳ��� ���� ��Ұ� ������ 1����
		return 1;
	}

	// ������ ���� �޼ҵ�� ���� �������� ����
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
		// 2���� �迭 map�� �Է�.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// i=0 ~ N-1���� ����, �Ʒ� �������� ������ �� �ִ��� Ȯ���ϸ� answer�� �����ش�.
		for (int i = 0; i < N; i++) {
			answer += Dcheck(i) + Rcheck(i);
		}
		System.out.println(answer);
	}
}
