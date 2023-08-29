
import java.util.LinkedList;
import java.util.Queue;
//늑대와 양 실버3
import java.util.Scanner;

class point{
	int x;
	int y;
	public point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int R,C;
	static char[][] map;
	static char[][] clonemap;
	static Queue<point> Q;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int BFS() {
		while(!Q.isEmpty()) {
			point p=Q.poll();
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				if(nx>=0&&nx<R&&ny>=0&&ny<C&&clonemap[nx][ny]!='W'&&clonemap[nx][ny]!='D') {
					if(clonemap[nx][ny]=='.') {
						clonemap[nx][ny]='W';
						Q.add(new point(nx,ny));
					}else {
						if(map[p.x][p.y]=='W') return 0;
						clonemap[p.x][p.y]='D';
						map[p.x][p.y]='D';
					}
				}
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		map=new char[R][C];
		clonemap=new char[R][C];
		Q=new LinkedList<>();
		for(int i=0;i<R;i++) {
			String str=sc.next();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
				clonemap[i][j]=str.charAt(j);
				if(str.charAt(j)=='W') Q.add(new point(i,j));
			}
		}
		if(BFS()==1) {
			System.out.println(1);
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else System.out.println(0);
	
	}
}
