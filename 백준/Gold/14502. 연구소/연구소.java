import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class point_14502{
    int x,y;

    public point_14502(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int n,m;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static int answer=Integer.MIN_VALUE;
    static ArrayList<point_14502> List=new ArrayList<>();

    public static void arraycals(int[][] map,int s,int L){
        if(L==3){
            int[][] cmap=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    cmap[i][j]=map[i][j];
                }

            }
            answer=Math.max(count(cmap),answer);
        }else{
            for(int i=s;i<List.size();i++){
                map[List.get(i).x][List.get(i).y]=1;
                arraycals(map,i+1,L+1);
                map[List.get(i).x][List.get(i).y]=0;
            }
        }
    }
    public static int count(int[][] map){
        Queue<point_14502> Q=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==2){
                    Q.offer(new point_14502(i,j));
                    while(!Q.isEmpty()){
                        point_14502 p=Q.poll();
                        for(int k=0;k<4;k++){
                            int nx=p.x+dx[k];
                            int ny=p.y+dy[k];
                            if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]==0){
                                map[nx][ny]=2;
                                Q.offer(new point_14502(nx,ny));
                            }
                        }
                    }

                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int[][] map=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=sc.nextInt();
                if(map[i][j]==0) List.add(new point_14502(i,j));
            }
        }
        arraycals(map,0,0);
        System.out.println(answer);
    }
}
