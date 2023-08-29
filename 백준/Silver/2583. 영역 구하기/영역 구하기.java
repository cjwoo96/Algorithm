
import java.util.*;

class spot_{
    int x,y;
    public spot_(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int n,m,k;
    static int[][] arr;
    static Queue<spot_> Q=new LinkedList<>();
    static int[] dx={0,-1,0,1};
    static int answer=0;
    static ArrayList<Integer> List=new ArrayList<>();
    static int[] dy={-1,0,1,0};
    public static void DFS_(){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0) {
                    int len=1;
                    answer++;
                    Q.offer(new spot_(i,j));
                    arr[i][j]=1;
                    while(!Q.isEmpty()){
                        spot_ sp=Q.poll();

                        for(int l=0;l<4;l++){
                            int nx=sp.x+dx[l];
                            int ny=sp.y+dy[l];
                            if(nx>=0&&nx<=m-1&&ny>=0&&ny<=n-1&&arr[nx][ny]==0){
                                arr[nx][ny]=1;
                                Q.offer(new spot_(nx,ny));
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
        m=sc.nextInt();
        n=sc.nextInt();
        k=sc.nextInt();
        arr=new int[m][n];
        for(int i=0;i<k;i++){
            int ax=sc.nextInt();
            int ay=sc.nextInt();
            int bx=sc.nextInt();
            int by=sc.nextInt();
            for(int j=ax;j<bx;j++){
                for(int s=m-by;s<m-ay;s++){
                    arr[s][j]=1;
                }
            }
        }

        DFS_();
        System.out.println(answer);
        Collections.sort(List);
        for(int x:List){
            System.out.print(x+" ");
        }
    }
}