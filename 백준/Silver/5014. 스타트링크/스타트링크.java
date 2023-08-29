import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int F,S,G,U,D;
    static int[] ch;

    static int answer=0;
    static Queue<Integer> Q=new LinkedList<>();
    public static boolean BFS_50(){

        while (!Q.isEmpty()) {
            int tmp=Q.size();

            for (int i = 0; i < tmp; i++) {
                int v = Q.poll();
                if(v==G) {
                    return true;
                }
                if (v+U <= F&&ch[v + U] == 0 ) {
                    ch[v + U] = 1;
                    Q.offer(v + U);
                }
                if (v - D > 0&&ch[v - D] == 0 ) {
                    ch[v - D] = 1;
                    Q.offer(v - D);
                }

            }
            answer++;
           
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        F=sc.nextInt();
        S=sc.nextInt();
        G=sc.nextInt();
        U=sc.nextInt();
        D=sc.nextInt();
        ch=new int[F+1];
        ch[S]=1;
        Q.offer(S);
        if(BFS_50()) System.out.println(answer);
        else System.out.println("use the stairs");





    }
}