
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int r,c;
    static ArrayList<Character> List=new ArrayList<>();
    static char[][] arr;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    static int answer=0;
    public static void DFS_19(int x,int y){

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
//            System.out.println("i번 : "+i);
            if(nx>=0&&ny>=0&&nx<r&&ny<c&&!List.contains(arr[nx][ny])){
                List.add(arr[nx][ny]);
//                System.out.println("add data : "+arr[nx][ny]);
                DFS_19(nx,ny);
//                System.out.println();
//                System.out.println("remove data : "+arr[nx][ny]);
                List.remove(Character.valueOf(arr[nx][ny]));
            }
        }
        answer=Math.max(answer,List.size());
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();

        arr=new char[r][c];
        for(int i=0;i<r;i++){
            String str=sc.next();
            for(int j=0;j<c;j++){
                arr[i][j]=str.toCharArray()[j];
            }
        }
        List.add(arr[0][0]);
        DFS_19(0,0);
        System.out.println(answer);
//        for(char x:List){
//            System.out.println(x);
//        }

    }
}
