import java.util.*;

class spot_2667{
    int x,y;
    public spot_2667(int x,int y){
        this.x=x;
        this.y=y;

    }
}
public class Main {
    static int n;
    static int answer=0;
    static int[][] arr;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static ArrayList<Integer> List =new ArrayList<>();
    static Queue<spot_2667> Q=new LinkedList<>();
    public static void DFS_2667(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    Q.offer(new spot_2667(i,j));
                    arr[i][j]=0;
                    int len=1;
                    answer++;
                    while(!Q.isEmpty()){
                        spot_2667 sp=Q.poll();
                        for(int s=0;s<4;s++){
                            int nx=dx[s]+sp.x;
                            int ny=dy[s]+sp.y;
                            if(nx<=n-1&&ny<=n-1&&nx>=0&&ny>=0&&arr[nx][ny]==1){
                                Q.offer(new spot_2667(nx,ny));
                                arr[nx][ny]=0;
                                len++;
                            }
                        }
                    }
                    List.add(len);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        String str="";
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            str=sc.next();
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(str.substring(j,j+1));
            }
        }

        DFS_2667();
        System.out.println(answer);
        Collections.sort(List);
        for(int x:List){
            System.out.println(x);
        }
    }
}