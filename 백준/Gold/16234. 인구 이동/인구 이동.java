
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx= {0,1,-1,0};
	static int[] dy= {1,0,0,-1};
	static int N,L,R,answer;
	static int[][] map;
	static boolean[][] lockedVisted;
	static class point {
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static boolean bfs() {
		int[][] Newmap=new int[N][N];
		int[] Sum=new int[N*N+1];
		boolean flag=false;
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(Newmap[i][j]==0&&!lockedVisted[i][j]) {
					boolean[][] visited=new boolean[N][N];
					visited[i][j]=true;
					int sum=0;
					int size=0;
					Newmap[i][j]=++count;
					
					Queue<point> Q=new LinkedList<>();
					Q.add(new point(i,j));
					while(!Q.isEmpty()) {
						point p=Q.poll();
						lockedVisted[p.x][p.y]=false;
						sum+=map[p.x][p.y];
						size++;
						for(int k=0;k<4;k++) {
							int nx=p.x+dx[k];
							int ny=p.y+dy[k];
							if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&(Math.abs(map[p.x][p.y]-map[nx][ny])>=L&&Math.abs(map[p.x][p.y]-map[nx][ny])<=R)) {
								Q.add(new point(nx,ny));
								Newmap[nx][ny]=count;
								visited[nx][ny]=true;
								flag=true;
								
							}
						}
					}
					if(size==1) lockedVisted[i][j]=true;
					Sum[count]=sum/size;
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(Newmap[i][j]==0) continue;
				map[i][j]=Sum[Newmap[i][j]];
			}
		}
		if(flag) return true;
		else return false;
		
		
		
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		lockedVisted=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		answer=0;
		while(true) {
			if(bfs()) answer++;
			else break;
		}
		System.out.println(answer);
		
		
	}
}
