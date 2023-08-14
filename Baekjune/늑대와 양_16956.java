package Baekjune;
import java.util.LinkedList;
import java.util.Queue;
//����� �� �ǹ�3
import java.util.Scanner;
// ��ǥ�� ������ point Ŭ���� ����.
// ������ ��ġ�� Q�� �̸� �����ϱ� ���� x,y ��ǥ�� ������ �� �ִ� Ŭ������ �������. 
class point{
	int x;
	int y;
	public point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
public class _16956 {
	//static���� ����� �޼��忡 �����ϱ� ���� ������ ũ�⸦ �������� ����
	static int R,C;
	// ������ ���¸� �޾ƿ���, �������� ��Ÿ���� ģ ����� ������ ����� map �迭 ����
	static char[][] map;
	// BFS���� Ž���� �Ҷ� ���밡 ������ ����  W�� �ٲ�� ������ ��꿡 �ʿ��� clonemap����
	static char[][] clonemap;
	static Queue<point> Q;
	// �������� ���� Ž���� ���� dx, dy �迭 ����.
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int BFS() {
		//Q�� ����ٴ� ���� ��Ÿ���� ��� W�� D�� á�ٴ� ��. �׋� �ߴ�. 
		while(!Q.isEmpty()) {
			//W�� ��ġ�� poll
			point p=Q.poll();
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				// ��Ÿ�� �迭 �����δ� ������ �ȵǰ�, �̹� ���밡 �ִ°��� �̹� ť�� ������ �Ǿ��ְų� �̹� Ȯ�� �� ���̹Ƿ� �ȵ�. �� ��Ÿ���� �� �� ����.
				if(nx>=0&&nx<R&&ny>=0&&ny<C&&clonemap[nx][ny]!='W'&&clonemap[nx][ny]!='D') {
					//���� clonemap[nx][ny]�� �� �� �ִ� �����̶�� W�� ����. ���밡 �̵��ߴٴ� �� �׸��� ť�� �߰�.
					if(clonemap[nx][ny]=='.') {
						clonemap[nx][ny]='W';
						Q.add(new point(nx,ny));
					}else {
						// else�� ���� �ִ� ��ġ��°��ε� ���� ���� ��ġ�� map�迭�� W���ִٸ� W���� ��Ÿ���� ĥ ���� �����Ƿ� 0�� �����ϰ� 
						// �װ��� �ƴ϶�� ���� ��ġ�� ��Ÿ��(D)�� ģ��. 
						if(map[p.x][p.y]=='W') return 0;
						clonemap[p.x][p.y]='D';
						map[p.x][p.y]='D';
					}
				}
			}
		}
		//��� Ž���ߴµ� ���� ������ ���ϴ� ��Ȳ�� ������ 1��ȯ.
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
				// ������ ��ġ�� �̸� Q�� ����.
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
			//ó���� else�� BFS()�� �־��µ� 0�� ��ȯ�Ǵ� ���� �ƴ� 1�� ��ȯ��
			//�̴� if������ �̹� BFS�� �ѹ� ���ұ� ������ Q�� �ƹ��͵� ���� ��Ȳ�� ���� �� �ֱ� �����̴�
			//ex) ó���� ���밡 �Ѹ��� �ۿ������ٸ� ������ bfs�� ������ �Ѹ����ִ� ���븦 ť���� ���Ե�.
			//�׷��� �ȴٸ� �ؿ� bfs������ ���ۺ��� ť�� ������Ƿ� �ٷ� 1�� ����.
			//�Ǽ����� �ʰ� ��������!
		}else System.out.println(0);
	
	}
}
