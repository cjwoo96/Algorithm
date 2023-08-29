
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int mv=0;
    static int zv=0;
    static int ov=0;
    public static void Split(int xst,int xed,int yst,int yed){
        int start=arr[xst][yst];
        int len=(xed-xst+1)/3;
        boolean flag=true;
        for(int i=xst;i<=xed;i++) {
            for (int j = yst; j <= yed; j++) {
                if (arr[i][j] != start) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            if (start==0) zv++;
            else if(start==1) ov++;
            else mv++;
        }else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    Split(xst+len*i,xst+len*(i+1)-1,yst+len*j,yst+len*(j+1)-1);
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Split(0,n-1,0,n-1);
        System.out.println(mv);
        System.out.println(zv);
        System.out.println(ov);
    }
}