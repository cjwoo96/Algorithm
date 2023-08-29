import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class point_3055{
    int x,y;
    public point_3055(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static boolean flag=false;
    static int n,m;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static int answer=0;
    static int[][] ch;
    static Queue<point_3055> QS=new LinkedList<>();
    static Queue<point_3055> W=new LinkedList<>();
    public static void BFS_3055(){

        while(!QS.isEmpty()){

            int wsize=W.size();
            for(int j=0;j<wsize;j++){
            point_3055 w=W.poll();
            for(int i=0;i<4;i++){
                int nwx=w.x+dx[i];
                int nwy=w.y+dy[i];
                if(nwx>=0&&nwx<n&&nwy>=0&&nwy<m&&((map[nwx][nwy]=='.')||(map[nwx][nwy]=='S'))){
                    map[nwx][nwy]='*';
                    W.offer(new point_3055(nwx,nwy));
                }
            }
            }

            int qssize=QS.size();
            for(int i=0;i<qssize;i++){
                point_3055 qs=QS.poll();
                for(int j=0;j<4;j++){
                    int nqx=qs.x+dx[j];
                    int nqy=qs.y+dy[j];
                    if(nqx>=0&&nqx<n&&nqy>=0&&nqy<m&&ch[nqx][nqy]==0&&(map[nqx][nqy]=='.'||map[nqx][nqy]=='D')){
                        ch[nqx][nqy]=ch[qs.x][qs.y]+1;

                        if(map[nqx][nqy]=='D') {
                            answer=ch[nqx][nqy]-1;
                            flag=true;
                            return;
                        }
                        QS.offer(new point_3055(nqx,nqy));
                    }
                }
            }

        }

    }
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new char[n][m];
        ch=new int[n][m];
        for(int i=0;i<n;i++){
            String str=sc.next();
            for(int j=0;j<m;j++){
                map[i][j]=str.charAt(j);
                if(map[i][j]=='S') {
                    ch[i][j]=1;

                    QS.offer(new point_3055(i,j));
                }
                if(map[i][j]=='*') W.offer(new point_3055(i,j));
            }
        }


        BFS_3055();
        if(flag) System.out.println(answer);
        else System.out.println("KAKTUS");

    }
}