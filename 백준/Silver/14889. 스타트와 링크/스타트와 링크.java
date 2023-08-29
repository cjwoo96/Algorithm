import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] ch;
    static int[][] arr;
    static int answer=Integer.MAX_VALUE;
    public static int cal(int[] ch){
        ArrayList<Integer> List1=new ArrayList<>();
        ArrayList<Integer> List2=new ArrayList<>();
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n;i++){
            if(ch[i]==1) List1.add(i);
            else List2.add(i);
        }
        for(int i=0;i<n/2;i++){
            for(int j=i+1;j<n/2;j++){
                sum1+=arr[List1.get(i)][List1.get(j)]+arr[List1.get(j)][List1.get(i)];
                sum2+=arr[List2.get(i)][List2.get(j)]+arr[List2.get(j)][List2.get(i)];
            }
        }
//        System.out.println(Math.abs(sum1-sum2));
        return Math.abs(sum1-sum2);
    }
    public static void bf(int L,int s){
        if(L==n/2-1){
            answer=Math.min(answer,cal(ch));
        }else{
            for(int i=s;i<=n-1;i++){
                ch[i]=1;
                bf(L+1,i+1);
                ch[i]=0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        ch=new int[n];
        arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        ch[0]=1;
        bf(0,1);
        System.out.println(answer);


    }
}
