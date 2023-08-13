package practice_Git02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209 {

	static int[][] arr=new int[100][100];
	
	static int rowcolumn(int r) {
		int answer1=0;
		int answer2=0;
		for(int i=0;i<100;i++) {
			answer1+=arr[i][r];
			answer2+=arr[r][i];
		}
		return Math.max(answer1, answer2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] answer=new int[10];
		
		
		for(int i=0;i<10;i++) {
			int max=0;
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			for(int j=0;j<100;j++) {
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<100;k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			for(int j=0;j<100;j++) {
				max=Math.max(rowcolumn(j), max);
			}
			int sum1=0;
			int sum2=0;
			for(int j=0;j<100;j++) {
				sum1+=arr[j][j];
				sum2+=arr[99-j][j];
			}
			answer[i]=Math.max(max,Math.max(sum1, sum2));
		}
		for(int i=0;i<10;i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
	}
}
