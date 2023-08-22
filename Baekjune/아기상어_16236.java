package Baekjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// �Ʊ���� ����� ��ġ�� ������ point class
class point_16236 implements Comparable<point_16236> {
	int x;
	int y;

	public point_16236(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// ���� ���ǿ� �°� �� ��� ����� �켱���ĵǰ� compareTo ����.
	@Override
	public int compareTo(point_16236 o) {
		if (this.x < o.x)
			return -1;
		else if (this.x == o.x) {
			if (this.y < o.y)
				return -1;
			else
				return 1;
		} else
			return 1;
	}
}

public class �Ʊ���_16236 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// ���� �Ÿ��� �ִ� ���� �� �ִ� �������� ������ ������ �켱 ������ �°� ������ �켱���� ť
		PriorityQueue<point_16236> pq = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());
		// �׹��� Ž���� �ʿ��� dx, dy �迭
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		int[][] map = new int[N][N];
		// ����⸦ ��Ƹ԰� ���� ����⸦ ��Ƹ��������� �� �ܰ踶�� �湮�� ���� �湮���� �ʰ� �ϱ� ���� check�迭 ����.
		int[][] check = new int[N][N];
		// ��� ������ ����.
		int shark = 2;
		// ���� ����� �� ����.
		int eat = 0;
		// �ɸ� �ð� ����.
		int Time = 0;
		// ����� ����� ������ �迭�� ������������ ���� �� ����⸦ ���������� �ε����� �ø��� ��� ���� �� �ִ� ����Ⱑ �ִ��� Ȯ��
		int idx = 0;
		// ���̻� ��� ���� �� �ִ� ����Ⱑ ���������� ������ �ð��� ����.
		int answer = 0;
		// ������� ����� ������������ ������ �迭 ����
		ArrayList<Integer> list = new ArrayList<>();
		// �� �̵��� ĭ�� ������ ť ����.
		Queue<point_16236> Q = new LinkedList<>();
		// map�� �Է¹���.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					// �����ġ�� Q�� �̸� �־�ΰ� ����� ��ġ�� 0���� �ʱ�ȭ
					Q.add(new point_16236(i, j));
					map[i][j] = 0;
					// �� �ִ� ��ġ�� ���� ��ġ�̹Ƿ� üũ�迭�� üũ���ش�.
					check[i][j] = 1;
					// ����� ����Ʈ�� ����
				} else if (map[i][j] != 0)
					list.add(map[i][j]);
			}
		}
		// ����⸦ ������������ ����.
		Collections.sort(list);

		// ť�� ���� �ʾ����� (���� �� ���� ��������), ���� ����Ⱑ ��������, ���� ����� �� ���� ���� ����Ⱑ ���� ������ while����
		// �ݺ��Ѵ�.
		while (!Q.isEmpty() && list.size() > idx && shark > list.get(idx)) {
			// �� �ܰ躰�� Time�� �������Ѿ� �ϹǷ� �̹� �ܰ� Q�� ũ�⸦ �̸� ����.
			int size = Q.size();
			Time++;
			// ť �����ŭ for�� �ݺ�.
			for (int i = 0; i < size; i++) {
				// ť���� ����Ʈ�� �̾� 4���� Ž��
				point_16236 p = Q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					// ����� ���� ��ġ�� map�ȿ� �ְ�, ���� ��ġ�� ���� ū ����Ⱑ ������, �̹� �湮�� ������ �ƴѰ��
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] <= shark && check[nx][ny] == 0) {
						// ��Ʈ��ŷ / �̹� ��Ƹ��� �� �ִ� ����Ⱑ �켱���� ť�� ����Ǿ� ������ ���� ����Ⱑ �켱����ť�� peek���� �켱������ ������ ��
						// �ʿ䰡 ����.
						if (!pq.isEmpty() && pq.peek().x < nx)
							continue;
						// �� �� ĭ�� �� ���� �� �ִ� ����Ⱑ �ִ� ���. ���� �ܰ迡���� ���������� �Ÿ��� ���� ������ �켱������ �Ǵ��ϱ����� �켱����
						// ť�� �־��ش�.
						if (map[nx][ny] < shark && map[nx][ny] != 0) {
							pq.add(new point_16236(nx, ny));
							check[nx][ny] = 1;
							// �� �� ĭ�� �� ������ ���. ť���� �־��ش�.
						} else {
							Q.add(new point_16236(nx, ny));
							check[nx][ny] = 1;
						}
					}
				}
			}
			// ���� �� �ִ� ����Ⱑ �켱���� ť�� ���� ����Ǿ� ������, �켱���� ť�� ���� �տ� ���� �̾Ƴ��� pq, Q�� ��� �� Q�� ����
			// ������� ��ġ�� ����.
			if (!pq.isEmpty()) {
				// ����⸦ ��ƸԾ������� answer�� Time���� �ʱ�ȭ�Ѵ�.
				answer = Time;
				point_16236 P = pq.poll();
				pq.clear();
				Q.clear();
				Q.add(P);
				// ���� ����� ���� �����ϰ� �� ���� ��� ũ��� �������� ��� ũ�⸦ ������Ű��, ���� ����⸦ 0���� �ʱ�ȭ
				eat++;
				if (eat == shark) {
					shark++;
					eat = 0;
				}
				// ��Ƹ��� ����Ⱑ �ִ� ĭ�� 0���� �ʱ�ȭ
				idx++;
				map[P.x][P.y] = 0;
				// üũ�迭�� �ٽ� �ʱ�ȭ
				check = new int[N][N];
				check[P.x][P.y] = 1;
			}
		}
		System.out.println(answer);
	}
}
