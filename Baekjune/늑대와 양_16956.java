package Baekjune;
import java.util.LinkedList;
import java.util.Queue;
//늑대와 양 실버3
import java.util.Scanner;
// 좌표를 저장할 point 클래스 선언.
// 늑대의 위치를 Q에 미리 저장하기 위해 x,y 좌표를 포괄할 수 있는 클래스를 만들었다. 
class point{
	int x;
	int y;
	public point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
public class _16956 {
	//static으로 선언된 메서드에 접근하기 위해 목장의 크기를 전역으로 선언
	static int R,C;
	// 목장의 형태를 받아오고, 마지막에 울타리를 친 모습을 저장해 출력할 map 배열 선언
	static char[][] map;
	// BFS으로 탐색을 할때 늑대가 지나간 곳은  W로 바뀌기 때문에 계산에 필요한 clonemap선언
	static char[][] clonemap;
	static Queue<point> Q;
	// 동서남북 방향 탐색을 위한 dx, dy 배열 선언.
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int BFS() {
		//Q가 비었다는 것은 울타리가 모두 W나 D로 찼다는 것. 그떄 중단. 
		while(!Q.isEmpty()) {
			//W의 위치를 poll
			point p=Q.poll();
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				// 울타리 배열 밖으로는 나가면 안되고, 이미 늑대가 있는곳은 이미 큐에 저장이 되어있거나 이미 확인 한 곳이므로 안됨. 또 울타리도 갈 수 없음.
				if(nx>=0&&nx<R&&ny>=0&&ny<C&&clonemap[nx][ny]!='W'&&clonemap[nx][ny]!='D') {
					//만약 clonemap[nx][ny]이 갈 수 있는 지형이라면 W로 저장. 늑대가 이동했다는 뜻 그리고 큐에 추가.
					if(clonemap[nx][ny]=='.') {
						clonemap[nx][ny]='W';
						Q.add(new point(nx,ny));
					}else {
						// else란 양이 있는 위치라는것인데 만약 이전 위치의 map배열에 W가있다면 W위에 울타리를 칠 수는 없으므로 0을 리턴하고 
						// 그것이 아니라면 이전 위치에 울타리(D)를 친다. 
						if(map[p.x][p.y]=='W') return 0;
						clonemap[p.x][p.y]='D';
						map[p.x][p.y]='D';
					}
				}
			}
		}
		//모두 탐색했는데 양이 피하지 못하는 상황이 없으면 1반환.
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
				// 늑대의 위치는 미리 Q에 저장.
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
			//처음에 else에 BFS()를 넣었는데 0이 반환되는 것이 아닌 1이 반환됨
			//이는 if문에서 이미 BFS가 한번 돌았기 때문에 Q에 아무것도 없는 상황이 생길 수 있기 때문이다
			//ex) 처음에 늑대가 한마리 밖에없었다면 위에서 bfs를 돌릴때 한마리있는 늑대를 큐에서 빼게됨.
			//그렇게 된다면 밑에 bfs에서는 시작부터 큐는 비었으므로 바로 1이 리턴.
			//실수하지 않게 조심하자!
		}else System.out.println(0);
	
	}
}
