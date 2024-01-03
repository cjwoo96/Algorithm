package _Baekjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 물고기 정보를 저장할 클래스 선언.
// 물고기의 위치는 배열에 저장 할 것이므로 방향과 숫자만 저장.
class Fish2 {
	int dir;
	int num;

	public Fish2(int dir, int num) {
		this.dir = dir;
		this.num = num;
	}
}

public class 청소년상어RE {
	// 답을 저장할 answer 변수 선언
	static int answer = Integer.MIN_VALUE;
	// 문제에서 주어진 방향에 맞게 dx,dy 선언. 1부터 8까지 이므로 그 인덱스에 맞게 생성.
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };

	static void DFS_F(int x, int y, int dir, int sum, Fish2[][] map) {
		// 객체를 배열에 저장했으므로 이차원 배열의 각 인덱스에는 각각의 객체를 참조
		// DFS에서 다음단계로 map을 넘겨줄때 각각의 단계에서의 변화값이 모든 단계의 map에 영향을 미침.
		// 따라서 깊은 복사가 필요.
		Fish2[][] Nmap = new Fish2[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == null)
					Nmap[i][j] = null;

				// 객체의 깊은 복사는 새로운 인스턴스를 생성해 넣어주어야 한다.
				// 기본 자료형은 = 으로도 가능하지만 참조 자료형에서는 = 은 주소를 참조함을 의미.
				else
					Nmap[i][j] = new Fish2(map[i][j].dir, map[i][j].num);
			}
		}
		// 상어의 위치의 물고기는 잡아먹혔으므로 null을 저장.
		Nmap[x][y] = null;
		// 물고기 위치 이동.
		// 깊은복사를 한 map과 상어 위치를 인자로 넘겨줌.
		Move(Nmap, x, y);
		// 상어가 이동 할 수 있는 위치가 있는지 확인할 boolean 선언
		boolean flag = false;
		// map의 최대 크기가 4이므로 1~3칸까지 움직이는 것 체크.
		for (int i = 1; i <= 3; i++) {
			// 상어의 방향으로 i번 움직임
			int nx = x + dx[dir] * i;
			int ny = y + dy[dir] * i;
			// 범위안에 있거나, 위치에 물고기가 있다면 물고기를 잡아먹음.
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && Nmap[nx][ny] != null) {
				flag = true;
				DFS_F(nx, ny, Nmap[nx][ny].dir, sum + Nmap[nx][ny].num, Nmap);
			}
		}
		if (!flag)
			answer = Math.max(answer, sum);

	}

	// 물고기의 위치를 조건에 맞게 이동시키는 메서드
	static void Move(Fish2[][] map, int x, int y) {
		// 1부터 16까지 작은 넘버의 물고기부터 이동
		L1: for (int i = 1; i <= 16; i++) {

			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					// 배열을 돌며 i와 같은 num을 가진 물고기가 있을 떄
					if (map[j][k] != null && map[j][k].num == i) {
						// 물고기가 가진 방향으로 물고기를 이동시킨다.
						int cnt = map[j][k].dir;
						// 이동한 방향이 배열을 벗어나거나 상어가 있는 위치면 45도 방향을 튼다.
						for (int l = 0; l < 8; l++) {
							int nx = j + dx[cnt];
							int ny = k + dy[cnt];
							if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == x && ny == y)) {
								// 두 물고기의 위치를 바꿔준다.
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
		// 물고기를 저장할 배열 선언.
		Fish2[][] arr = new Fish2[4][4];
		for (int i = 0; i < 4; i++) {
			// 물고기 배열에 저장.
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				arr[i][j] = new Fish2(dir, num);
			}
		}
		// 상어의 x위치, 상어의 y위치, 상어의 방향, 먹은 물고기 숫자 합, 현재 맵을 전달해준다.
		DFS_F(0, 0, arr[0][0].dir, arr[0][0].num, arr);
		System.out.println(answer);
	}
}
