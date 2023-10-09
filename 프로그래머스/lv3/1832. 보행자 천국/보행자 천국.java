import java.util.PriorityQueue;

class Solution {

	static class point implements Comparable<point> {
		int x, y;
		long len;

		public point(int x, int y, long len) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			return (int) (this.len - o.len);
		}

	}
    static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        long[][] Count = new long[m][n];
		Count[0][0] = 1;
		PriorityQueue<point> Q = new PriorityQueue<>();
		Q.add(new point(0, 0, 0));
		while (!Q.isEmpty()) {
			point p = Q.poll();
			for (int i = 0; i < 2; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && cityMap[nx][ny] != 1) {
					if (cityMap[nx][ny] == 2) {
						int cnt = 1;
						while (nx >= 0 && nx < m && ny >= 0 && ny < n&&cityMap[nx][ny] == 2) {
							cnt++;
							nx += dx[i];
							ny += dy[i];
						}

						if (nx >= 0 && nx < m && ny >= 0 && ny < n && cityMap[nx][ny] != 1) {
							if (Count[nx][ny] == 0) {
								Count[nx][ny] = Count[p.x][p.y];
								Q.add(new point(nx, ny, p.len + cnt));
							} else {
								Count[nx][ny] += Count[p.x][p.y];
							}
                             Count[nx][ny]=Count[nx][ny] % MOD;
						}
					} else {
						if (Count[nx][ny] == 0) {
							Count[nx][ny] = Count[p.x][p.y];
							Q.add(new point(nx, ny, p.len + 1));
						} else {
							Count[nx][ny] += Count[p.x][p.y];
						}
                         Count[nx][ny]=Count[nx][ny] % MOD;
					}

				}
               

			}
		}
		return (int)(Count[m - 1][n - 1]);
    }
}