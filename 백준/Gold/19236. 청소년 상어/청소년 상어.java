
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish2 {
	int dir;
	int num;

	public Fish2(int dir, int num) {
		this.dir = dir;
		this.num = num;
	}
}

public class Main {
	static int answer = Integer.MIN_VALUE;
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

	static void DFS_F(int x, int y, int dir, int sum, Fish2[][] map) {
		Fish2[][] Nmap = new Fish2[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == null)
					Nmap[i][j] = null;

				else
					Nmap[i][j] = new Fish2(map[i][j].dir, map[i][j].num);
			}
		}
		Nmap[x][y] = null;
		Move(Nmap, x, y);
		boolean flag = false;
		for (int i = 1; i <= 3; i++) {
			int nx = x + dx[dir] * i;
			int ny = y + dy[dir] * i;
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && Nmap[nx][ny] != null) {
				flag = true;
				DFS_F(nx, ny, Nmap[nx][ny].dir, sum + Nmap[nx][ny].num, Nmap);
			}
		}
		if (!flag)
			answer = Math.max(answer, sum);

	}

	static void Move(Fish2[][] map, int x, int y) {
		L1: for (int i = 1; i <= 16; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (map[j][k] != null && map[j][k].num == i) {
						int cnt = map[j][k].dir;
						for (int l = 0; l < 8; l++) {
							int nx = j + dx[cnt];
							int ny = k + dy[cnt];
							if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == x && ny == y)) {
								Fish2 f = map[j][k];
								f.dir = cnt;
								map[j][k] = map[nx][ny];
								map[nx][ny] = f;
								continue L1;
							}
							cnt++;
							if (cnt == 9)
								cnt = 1;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Fish2[][] arr = new Fish2[4][4];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				arr[i][j] = new Fish2(dir, num);
			}
		}
		DFS_F(0, 0, arr[0][0].dir, arr[0][0].num, arr);
		System.out.println(answer);
	}
}
