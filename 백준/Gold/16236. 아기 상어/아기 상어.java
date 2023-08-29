
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point1 {
	int x;
	int y;

	public point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Integer> fishsize = new ArrayList<>();
	static Queue<point1> Spos = new LinkedList<point1>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int[][] check = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					Spos.add(new point1(i, j));
					check[i][j] = 1;
					map[i][j] = 0;
				} else if (map[i][j] > 0) {
					fishsize.add(map[i][j]);
				}
			}
		}
		int answer = 0;
		int Time = 0;
		int eat = 0;
		int shark = 2;
		point1 cfish = null;
		Collections.sort(fishsize);
		while (!Spos.isEmpty() && fishsize.size() != 0 && shark > fishsize.get(0)) {
			int size = Spos.size();
			Time++;
			for (int i = 0; i < size; i++) {
				point1 p = Spos.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && check[nx][ny] == 0 && shark >= map[nx][ny]) {
						check[nx][ny] = 1;
						if (shark > map[nx][ny] && map[nx][ny] != 0) {
							if (cfish == null)
								cfish = new point1(nx, ny);
							else {
								if (cfish.x < nx)
									continue;
								else if (cfish.x == nx) {
									if (cfish.y < ny)
										continue;
								}
								cfish = new point1(nx, ny);
							}
						} else {
							if (cfish == null) {
								Spos.add(new point1(nx, ny));
							}
						}
					}
				}

			}
			if (cfish != null) {
				eat++;
				if (eat == shark) {
					eat = 0;
					shark++;
				}
				answer = Time;
				fishsize.remove(Integer.valueOf(map[cfish.x][cfish.y]));
				map[cfish.x][cfish.y] = 0;
				Spos.clear();
				Spos.add(cfish);
				check = new int[N][N];
				check[cfish.x][cfish.y] = 1;
				cfish = null;

			}
		}
		System.out.println(answer);
	}
}
