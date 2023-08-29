import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class point_14923{
    int x,y,w;
    public point_14923(int x,int y,int w){
        this.x=x;
        this.y=y;
        this.w=w;
    }
}
public class Main {
    static int n,m,sx,sy,lx,ly;
    static int[][] map;
    static int[][][] ch;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static boolean flag=false;
    static int answer=0;
    public static void BFS_14923(){
        Queue<point_14923> Q=new LinkedList<>();
        Q.offer(new point_14923(sx,sy,0));
        ch[sx][sy][0]=1;
        while (!Q.isEmpty()){
            point_14923 p=Q.poll();
//            System.out.println("ch="+ch[p.x][p.y][p.w]+" x : "+p.x+", y : "+p.y+" w : "+p.w);
            for(int i=0;i<4;i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&ch[nx][ny][p.w]==0){
                    if(map[nx][ny]==1&&p.w==0){
                        Q.offer(new point_14923(nx,ny,1));
                        ch[nx][ny][1]=ch[p.x][p.y][0]+1;
                    }
                    if(map[nx][ny]==0){
                        Q.offer(new point_14923(nx,ny,p.w));
                        ch[nx][ny][p.w]=ch[p.x][p.y][p.w]+1;
                    }
                    if(nx==lx&&ny==ly){
                        flag=true;
                        answer=ch[nx][ny][p.w];
                        return;
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        sx=Integer.parseInt(st.nextToken())-1;
        sy=Integer.parseInt(st.nextToken())-1;
        st=new StringTokenizer(br.readLine());
        lx=Integer.parseInt(st.nextToken())-1;
        ly=Integer.parseInt(st.nextToken())-1;
        map=new int[n][m];
        ch=new int[n][m][2];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        BFS_14923();
        if(flag) System.out.println(answer-1);
        else System.out.println(-1);

    }
}