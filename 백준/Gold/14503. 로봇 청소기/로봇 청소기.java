
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class point_14503{
    int x,y,dir;
    public point_14503(int x,int y,int dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }
}
public class Main {
    static int n,m,sx,sy,sd;
    static int[][] map;
    static int answer=0;
    static int[] dx={-1,0,1,0};
    static boolean br=false;
    static int[] dy={0,1,0,-1};
    public static void BFS_14503(){
        Queue<point_14503> Q=new LinkedList<>();
        Q.offer(new point_14503(sx,sy,sd));
        while(!Q.isEmpty()){
            point_14503 p=Q.poll();
            boolean flag=false;
            if(map[p.x][p.y]==0){
                map[p.x][p.y]=2;
//                System.out.println("("+p.x+","+p.y+")");
                answer++;
            }
            for(int i=0;i<4;i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    flag = true;
                    break;
                }
            }
                if(flag){

                    for(int j=0;j<4;j++) {
                       p.dir = p.dir - 1;
                        if (p.dir == -1) p.dir = 3;
                        int Nx=p.x+dx[p.dir];
                        int Ny=p.y+dy[p.dir];
                        if(Nx>=0&&Nx<=n&&Ny>=0&&Ny<m&&map[Nx][Ny]==0){

                            Q.offer(new point_14503(Nx,Ny,p.dir));
                            break;
                        }
                    }

                }else{
                    for(int k=0;k<=1;k++){
                        int ndir=0;
                        if(k==0){
                            ndir=p.dir-2;
                        }else if(k==1){
                            ndir=p.dir+2;
                        }

                        if(ndir<4&&ndir>=0){
                            int ex=p.x+dx[ndir];
                            int ey=p.y+dy[ndir];
                            if(map[ex][ey]==1) {
                                br=true;
                            }
                            else{
                                Q.offer(new point_14503(ex,ey,p.dir));
                            }
                        }
                    }
                }
            if(br) break;
            }

        }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        sx=Integer.parseInt(st.nextToken());
        sy=Integer.parseInt(st.nextToken());
        sd=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        BFS_14503();
        System.out.println(answer);
    }
}