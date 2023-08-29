import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] arr=new int[5][5];
    static int[] dx={-1,0,1,0};
    static ArrayList<String> List=new ArrayList<>();
    static int answer=0;
    static int[] dy={0,-1,0,1};
    public static void DFS_2210(int x,int y,int L,String str){
        if(L==5){
            if(!List.contains(str)){
                List.add(str);
                answer++;
              
            }
        }else{
            for(int k=0;k<4;k++)
            {
                int nx=x+dx[k];
                int ny=y+dy[k];
                if(nx>=0&&nx<5&&ny>=0&&ny<5)
                {
                    str=str+arr[nx][ny];
                    DFS_2210(nx,ny,L+1,str);
                    str=str.substring(0,str.length()-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                DFS_2210(i,j,0,String.valueOf(arr[i][j]));
            }
        }

        System.out.println(answer);
    }
}
