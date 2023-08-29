
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class point_65{
    int z,x,y;
    public point_65(int z,int x,int y){
        this.z=z;
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int x,y,z;
    static Queue<point_65> Q=new LinkedList<>();
    static char[][][] arr;
    static int[] dz={0,0,0,0,-1,1};
    static int[] dx={-1,0,1,0,0,0};
    static int[] dy={0,-1,0,1,0,0};
    static int answer=0;
    public static int BFS(){
        while(!Q.isEmpty()){
            int size=Q.size();
            answer++;
            for(int i=0;i<size;i++){
            point_65 p=Q.poll();

            for(int j=0;j<6;j++){
                int nz=p.z+dz[j];
                int nx=p.x+dx[j];
                int ny=p.y+dy[j];
                if(nx>=0&&ny>=0&&nz>=0&&nz<z&&ny<y&&nx<x&&arr[nz][nx][ny]=='.'){
                    arr[nz][nx][ny]='#';
                    Q.offer(new point_65(nz,nx,ny));
                }
                if(nx>=0&&ny>=0&&nz>=0&&nz<z&&ny<y&&nx<x&&arr[nz][nx][ny]=='E'){
                    return answer;
                }
            }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        z=sc.nextInt();
        x=sc.nextInt();
        y=sc.nextInt();
        while(z!=0||x!=0||z!=0) {
            arr = new char[z][x][y];
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < x; j++) {
                    String str=sc.next();
                    for (int l = 0; l < y; l++) {
                        arr[i][j][l] = str.charAt(l);
                        if (arr[i][j][l] == 'S') Q.offer(new point_65(i, j, l));
                    }
                }
            }
            if(BFS()!=-1){
                System.out.println("Escaped in "+answer+" minute(s).");
            }else{
                System.out.println("Trapped!");
            }
            Q.clear();
            answer=0;
            z=sc.nextInt();
            x=sc.nextInt();
            y=sc.nextInt();
        }

    }
}