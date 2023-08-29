import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class point_1726{
    int x,y,d;
    public point_1726(int x,int y,int d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
}
public class Main {
    static int n,m,sx,sy,sd,lx,ly,ld;
    static int[][] map;
    static int[][][] ch;
    static boolean flag=false;
    static int answer=0;
    static int[] dx={0,0,0,1,-1};
    static int[] dy={0,1,-1,0,0};
    public static void BFS() {
        Queue<point_1726> Q = new LinkedList<>();
        Q.offer(new point_1726(sx, sy, sd));
        ch[sx][sy][sd] = 1;
        while (!Q.isEmpty()) {
            if (flag) break;
            point_1726 p = Q.poll();
//            System.out.println("x : "+p.x+", y : "+p.y+", d : "+p.d+", length : "+ch[p.x][p.y][p.d]);
            for (int i = 0; i < 5; i++) {
                int nx=0;
                int ny=0;
                int nd=0;
                if (i == 0) {
                    if (p.d == 1) {
                        nd = 3;
                    }
                    if (p.d == 2) {
                        nd = 4;
                    }
                    if (p.d == 3) {
                        nd = 2;
                    }
                    if (p.d == 4) {
                        nd = 1;
                    }
                    nx=p.x;
                    ny=p.y;
                } else if (i == 1) {
                    if (p.d == 1) {
                        nd = 4;
                    }
                    if (p.d == 2) {
                        nd = 3;
                    }
                    if (p.d == 3) {
                        nd = 1;
                    }
                    if (p.d == 4) {
                        nd = 2;
                    }
                    nx=p.x;
                    ny=p.y;

                }
                if(i>=2){
                    if(p.d==1){
                        nx=p.x;
                        ny=p.y+i-1;
                        nd=p.d;
                    }
                    if(p.d==2){
                        nx=p.x;
                        ny=p.y-i+1;
                        nd=p.d;
                    }
                    if(p.d==3){
                        nx=p.x+i-1;
                        ny=p.y;
                        nd=p.d;
                    }
                    if(p.d==4){
                        nx=p.x-i+1;
                        ny=p.y;
                        nd=p.d;
                    }

                    if(nx<0||nx>=n||ny<0||ny>=m||map[nx][ny]==1) break;
                }
                if(ch[nx][ny][nd]==0){
                    Q.offer(new point_1726(nx,ny,nd));
                    ch[nx][ny][nd]=ch[p.x][p.y][p.d]+1;
                    if(nx==lx&&ny==ly&&nd==ld){
                        answer=ch[nx][ny][nd];
                        flag=true;
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
        map=new int[n][m];
        ch=new int[n][m][5];
//        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        sx=Integer.parseInt(st.nextToken())-1;
        sy=Integer.parseInt(st.nextToken())-1;
        sd=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        lx=Integer.parseInt(st.nextToken())-1;
        ly=Integer.parseInt(st.nextToken())-1;
        ld=Integer.parseInt(st.nextToken());
        if(sx==lx&&sy==ly&&sd==ld){
            System.out.println(0);
        }else{
            BFS();
            System.out.println(answer-1);
        }



    }
}