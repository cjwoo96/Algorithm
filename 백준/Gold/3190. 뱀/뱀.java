
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class point_s {
	int x, y;

	public point_s(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (((point_s) obj).x == this.x && ((point_s) obj).y == this.y)
			return true;
		return false;
	}
}

public class Main {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a - 1][b - 1] = 1;
		}
		int l = sc.nextInt();
		int[] Time = new int[l];
		char[] Dir = new char[l];
		for (int i = 0; i < l; i++) {
			Time[i] = sc.nextInt();
			Dir[i] = sc.next().charAt(0);
		}
		Deque<point_s> dq = new ArrayDeque<point_s>();
		int t = 0;
		dq.add(new point_s(0, 0));
		int dir = 0;
		int idx = 0;
		while (true) {
			t++;
			int nx = dq.peek().x + dx[dir];
			int ny = dq.peek().y + dy[dir];
			if (!(nx >= 0 && nx < n && ny >= 0 && ny < n) || dq.contains(new point_s(nx, ny)))
				break;

			dq.addFirst(new point_s(nx, ny));
			if (arr[nx][ny] == 0)
				dq.removeLast();
			else
				arr[nx][ny] = 0;

			if (idx < l && t == Time[idx]) {
				if (Dir[idx] == 'D') {
					dir++;
				} else {
					dir--;
				}
				dir = (dir + 4) % 4;
				idx++;
			}

		}
		System.out.println(t);

	}
}
