
import java.util.*;

class point1{
    int x,y;
    public point1(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int n;
    static int[][] arr, ch;
    static int answer=0;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};

    static Queue<point1> Q=new LinkedList<>();
    public static int[][] ch1(int s){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]<=s) ch[i][j]=1;
            }
        }
        return ch;
    }
    public static void BFS_2468(){
        int add=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(ch[i][j]==0) {
                    Q.offer(new point1(i,j));
                    add++;
                    while(!Q.isEmpty()){
                        point1 p=Q.poll();
                        for(int k=0;k<4;k++){
                            int nx=p.x+dx[k];
                            int ny=p.y+dy[k];
                            if(nx>=0&&ny>=0&&nx<n&&ny<n&&ch[nx][ny]==0){
                                ch[nx][ny]=1;
                                Q.offer(new point1(nx,ny));
                            }
                        }
                    }
                }

            }
        }
        answer=Math.max(answer,add);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n][n];
        ch=new int[n][n];
        ArrayList<Integer> List=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
                if(!List.contains(arr[i][j])) List.add(arr[i][j]);
            }
        }
        List.add(0);

        for(int i=0;i<List.size();i++){
            ch1(List.get(i));
            BFS_2468();
            ch=new int[n][n];

        }
        System.out.println(answer);
    }
}
