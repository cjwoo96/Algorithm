import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Dot{    //빈좌표를 저장할 클래스 
	int x;
	int y;
	public Dot(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	
	static boolean isPossible(int[][] map,int x,int y,int n) {
		//같은 행 같은 열에 겹치는 인자 있는지 확인.
//		System.out.println("n = "+n+" 시작부분 실행"+"  x,y ->"+x+","+y);
		for(int i=0;i<9;i++) {
			if(map[x][i]==n) return false;
			
			if(map[i][y]==n) return false;
		}
//		System.out.println("n = "+n+" 실행");
		
		
		int three_x=(x/3)*3;
		int three_y=(y/3)*3;
		
		for(int i=three_x;i<three_x+3;i++) {
			for(int j=three_y;j<three_y+3;j++) {
				if(map[i][j]==n) return false;
			}
		}
//		System.out.println(n+"  ------------------------True--------------------------");
		return true;
	}
	
	static void dfs(int[][] map,ArrayList<Dot> arr,int idx) throws IOException {
		if(idx==arr.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					bw.write(String.valueOf(map[i][j])+" ");
				}
				bw.newLine();
			}
			bw.flush();
			bw.close();
			br.close();
			System.exit(0);
		}
		
		Dot d=arr.get(idx);
		
		for(int i=1;i<=9;i++) {
			
			if(isPossible(map,d.x,d.y,i)) 
			{
				map[d.x][d.y]=i;
				dfs(map,arr,idx+1);
				map[d.x][d.y]=0;
			}
		}	
	}
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		ArrayList<Dot> arr=new ArrayList<>();
		int[][] map=new int[9][9];
		
		for(int i=0;i<9;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				
				if(map[i][j]==0) arr.add(new Dot(i,j));
			}
		}
		
		dfs(map,arr,0);

	}

}
