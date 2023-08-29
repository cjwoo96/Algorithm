
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] arr,ch;
    static Queue<Integer> Q=new LinkedList<>();
    public static void BFS_13913(){
        while(!Q.isEmpty()){
            int now=Q.poll();

            int next;
            for(int i=0;i<3;i++) {
                if (i == 0) next = now + 1;
                else if (i == 1) next = now - 1;
                else next = 2 * now;

                if (next < 0 || next > 100000) continue;
                if (ch[next] == 0) {
                    ch[next] = ch[now] + 1;
                    arr[next] = now;
                    Q.offer(next);
                }



            }

        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        arr=new int[100001];
        ch=new int[100001];
        Q.offer(n);
        ch[n]=0;

        ArrayList<Integer> List=new ArrayList<>();
        if(m==n){
            System.out.println(0);
            System.out.println(m);
        }else
        {
            BFS_13913();
            int xnt=m;
            while(xnt!=n){
                List.add(xnt);
                xnt=arr[xnt];
            }
            List.add(xnt);
            System.out.println(ch[m]);
            for(int i=List.size()-1;i>=0;i--){
                System.out.print(List.get(i)+" ");
            }
        }
    }
}