import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class point_17141{
    int x,y;
    public point_17141(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int n,m;
    static int[] dx={-1,0,1,0};
    static int answer=Integer.MAX_VALUE;
    static int[] dy={0,-1,0,1};
    static ArrayList<point_17141> List=new ArrayList<>();
    public static int count(int[][] arr){
        Queue<point_17141> Q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==3) Q.offer(new point_17141(i,j));
            }
        }
        int cnt=-1;
        while(!Q.isEmpty()){
            int size=Q.size();
            cnt++;
            for(int i=0;i<size;i++){
                point_17141 p=Q.poll();
                for(int j=0;j<4;j++){
                    int nx=p.x+dx[j];
                    int ny=p.y+dy[j];
                    if(nx>=0&&nx<n&&ny>=0&&ny<n&&(arr[nx][ny]==0||arr[nx][ny]==2)){
                        arr[nx][ny]=3;
                        Q.offer(new point_17141(nx,ny));

                    }
                }
            }
        }
        boolean flag=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0||arr[i][j]==2) flag=false;
            }
        }
        if(flag) return cnt;
        else return Integer.MAX_VALUE;

    }
    public static void DFS_17141(int[][] arr,int L,int s){
        if(L==m){
            int[][] copymap=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    copymap[i][j]=arr[i][j];
//                    System.out.print(arr[i][j]+" ");
                }
//                System.out.println();
            }
//            System.out.println(count(copymap));
//            System.out.println();
//            System.out.println();
            answer=Math.min(answer,count(copymap));


        }else{
            for(int i=s;i<List.size();i++){
                arr[List.get(i).x][List.get(i).y]=3;
                DFS_17141(arr,L+1,i+1);
                arr[List.get(i).x][List.get(i).y]=2;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==2) List.add(new point_17141(i,j));
            }
        }
        DFS_17141(arr,0,0);
        if (answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}
