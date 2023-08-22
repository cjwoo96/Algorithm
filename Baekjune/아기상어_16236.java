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

// 아기상어와 물고기 위치를 저장할 point class
class point_16236 implements Comparable<point_16236> {
	int x;
	int y;

	public point_16236(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 문제 조건에 맞게 좌 상단 물고기 우선정렬되게 compareTo 구현.
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

public class 아기상어_16236 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 같은 거리에 있는 먹을 수 있는 물고기들을 위에서 구현한 우선 순위에 맞게 저장할 우선순위 큐
		PriorityQueue<point_16236> pq = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());
		// 네방향 탐색에 필요한 dx, dy 배열
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		int[][] map = new int[N][N];
		// 물고기를 잡아먹고 다음 물고기를 잡아먹을때까지 각 단계마다 방문한 곳은 방문하지 않게 하기 위한 check배열 선언.
		int[][] check = new int[N][N];
		// 상어 사이즈 저장.
		int shark = 2;
		// 먹은 물고기 수 저장.
		int eat = 0;
		// 걸린 시간 저장.
		int Time = 0;
		// 물고기 사이즈를 저장한 배열을 오름차순으로 정렬 후 물고기를 먹을때마다 인덱스를 올리며 잡아 먹을 수 있는 물고기가 있는지 확인
		int idx = 0;
		// 더이상 잡아 먹을 수 있는 물고기가 없을때까지 움직인 시간을 저장.
		int answer = 0;
		// 물고기의 사이즈를 오름차순으로 저장할 배열 선언
		ArrayList<Integer> list = new ArrayList<>();
		// 상어가 이동한 칸을 저장할 큐 생성.
		Queue<point_16236> Q = new LinkedList<>();
		// map을 입력받음.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					// 상어위치를 Q에 미리 넣어두고 상어의 위치를 0으로 초기화
					Q.add(new point_16236(i, j));
					map[i][j] = 0;
					// 상어가 있던 위치는 시작 위치이므로 체크배열에 체크해준다.
					check[i][j] = 1;
					// 물고기 리스트에 저장
				} else if (map[i][j] != 0)
					list.add(map[i][j]);
			}
		}
		// 물고기를 오름차순으로 정렬.
		Collections.sort(list);

		// 큐가 비지 않았을때 (아직 갈 곳이 남았을때), 먹을 물고기가 남았을떄, 남은 물고기 중 가장 작은 물고기가 상어보다 작을떄 while문을
		// 반복한다.
		while (!Q.isEmpty() && list.size() > idx && shark > list.get(idx)) {
			// 각 단계별로 Time을 증가시켜야 하므로 이번 단계 Q의 크기를 미리 구함.
			int size = Q.size();
			Time++;
			// 큐 사이즈만큼 for문 반복.
			for (int i = 0; i < size; i++) {
				// 큐에서 포인트를 뽑아 4방향 탐색
				point_16236 p = Q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					// 상어의 다음 위치가 map안에 있고, 다음 위치에 상어보다 큰 물고기가 없으며, 이미 방문한 지점이 아닌경우
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] <= shark && check[nx][ny] == 0) {
						// 백트래킹 / 이미 잡아먹을 수 있는 물고기가 우선순위 큐에 저장되어 있을때 현재 물고기가 우선순위큐의 peek보다 우선순위가 낮을때 볼
						// 필요가 없음.
						if (!pq.isEmpty() && pq.peek().x < nx)
							continue;
						// 상어가 온 칸에 상어가 먹을 수 있는 물고기가 있는 경우. 같은 단계에서는 물고기까지의 거리는 같기 때문에 우선순위를 판단하기위해 우선순위
						// 큐에 넣어준다.
						if (map[nx][ny] < shark && map[nx][ny] != 0) {
							pq.add(new point_16236(nx, ny));
							check[nx][ny] = 1;
							// 상어가 온 칸이 빈 공간일 경우. 큐에만 넣어준다.
						} else {
							Q.add(new point_16236(nx, ny));
							check[nx][ny] = 1;
						}
					}
				}
			}
			// 먹을 수 있는 물고기가 우선순위 큐에 여럿 저장되어 있을때, 우선순위 큐의 가장 앞에 것을 뽑아내고 pq, Q를 비운 후 Q에 뽑은
			// 물고기의 위치를 저장.
			if (!pq.isEmpty()) {
				// 물고기를 잡아먹었을때만 answer을 Time으로 초기화한다.
				answer = Time;
				point_16236 P = pq.poll();
				pq.clear();
				Q.clear();
				Q.add(P);
				// 먹은 물고기 수를 저장하고 이 값이 상어 크기와 같아지면 상어 크기를 증가시키고, 먹은 물고기를 0으로 초기화
				eat++;
				if (eat == shark) {
					shark++;
					eat = 0;
				}
				// 잡아먹은 물고기가 있는 칸은 0으로 초기화
				idx++;
				map[P.x][P.y] = 0;
				// 체크배열을 다시 초기화
				check = new int[N][N];
				check[P.x][P.y] = 1;
			}
		}
		System.out.println(answer);
	}
}
