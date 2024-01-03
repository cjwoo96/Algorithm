
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class point{
		int x,y;
		boolean ability;
		public point(int x, int y, boolean ability) {
			super();
			this.x = x;
			this.y = y;
			this.ability = ability;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[N][M];
		
		boolean[][][] visited=new boolean[N][M][2];
		
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str.substring(j, j+1));
			}
		}
		Queue<point> Q=new LinkedList<>();
		Q.add(new point(0,0,false));
		visited[0][0][0]=true;
		int Time=0;
		boolean flag=false;
		loop:while(!Q.isEmpty()) {
			int size=Q.size();
			Time++;
			for(int i=0;i<size;i++) {
				point p=Q.poll();
				if(p.x==N-1&&p.y==M-1) {
					flag=true;
					break loop;
				}
				for(int j=0;j<4;j++) {
					int nx=p.x+dx[j];
					int ny=p.y+dy[j];
					if(nx>=0&&nx<N&&ny>=0&&ny<M) {
						if(map[nx][ny]==0&&!visited[nx][ny][0]) {
							if(p.ability&&!visited[nx][ny][1]) {
								visited[nx][ny][1]=true;
								Q.add(new point(nx,ny,true));
							}else if(!p.ability) {
								visited[nx][ny][0]=true;
								Q.add(new point(nx,ny,false));
							}
						}else if(map[nx][ny]==1&&p.ability==false&&!visited[nx][ny][1]) {
							visited[nx][ny][1]=true;
							Q.add(new point(nx,ny,true));
						}
					}
				}
			}
		}
		if(flag) System.out.println(Time);
		else System.out.println(-1);
		
	}
}
