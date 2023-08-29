
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class point_15684{
    int x,y;
    public point_15684(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int n,m,h;
    static int answer=-1;
    static int[][][] map;
    static boolean flag;

    static ArrayList<point_15684> List=new ArrayList<>();
    public static void DB(int N,int sn,int d){
        for(int i=d;i<h;i++){

            if(N<n-1&&map[i][N][N+1]==1){
                DB(N+1,sn,i+1);
                return;
            }
            if(N>0&&map[i][N][N-1]==1){
                DB(N-1,sn,i+1);
                return;
            }
        }
        if(N!=sn){
            flag=true;
        }
    }
    public static void BFS_15683(int s,int L, int SL){
        if(L==SL){
            flag=false;
            for(int i=0;i<n;i++){
                DB(i,i,0);
                if(flag) return;
            }
            if(!flag) answer=SL;
        }else{
            for(int i=s;i<List.size();i++){
                int x=List.get(i).x;
                int y=List.get(i).y;
                map[x][y][y+1]=1;
                map[x][y+1][y]=1;
                BFS_15683(i+1,L+1,SL);
                map[x][y][y+1]=0;
                map[x][y+1][y]=0;
            }
        }
    }
    public static void DFS_15683(){
        for(int i=0;i<h;i++){
            for(int j=0;j<n-1;j++){
                if(j==0&&map[i][j][j+1]==0&&map[i][j+1][j+2]==0){
                    List.add(new point_15684(i,j));
                }
                else if(j==n-2&&map[i][j][j+1]==0&&map[i][j-1][j]==0){
                    List.add(new point_15684(i,j));
                }
                else if(j>0&&j<n-2&&map[i][j][j+1]==0&&map[i][j+1][j+2]==0&&map[i][j-1][j]==0){
                    List.add(new point_15684(i,j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());


            map = new int[h][n][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                map[x][y][y + 1] = 1;
                map[x][y + 1][y] = 1;
            }
            if(m==0) System.out.println(0);
            else if(n==2){
                if(m%2==1) System.out.println(1);
                else System.out.println(0);
            }else {
                DFS_15683();
                flag = false;
                for (int i = 0; i < n; i++) {
                    DB(i, i, 0);
                }
                if (!flag) System.out.println(0);
                else {
                    for (int i = 1; i <= 3; i++) {
                        BFS_15683(0, 0, i);
                        if (answer != -1) break;
                    }
                    System.out.println(answer);

                }
            }
    }
}