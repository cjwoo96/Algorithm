package practice_Git02;

import java.util.Scanner;

public class swea_11315 {

	static int n;
	static char[][] map;
	static int[] dx= {-1,-1,-1,0,1,1,1,0};
	static int[] dy= {-1,0,1,1,1,0,-1,-1};

	static boolean checking() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]=='o') {
					
					
					int si = i;
					int sj = j;
					for (int k = 0; k < 8; k++) {
						int cnt = 1;
						while (true) {
							int nx=si+dx[k];
							int ny=sj+dy[k];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 'o') {

								si = nx;
								sj = ny;
								cnt++;
								if (cnt == 5) return true;
								
							}else break;
						}
				}}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		String[] answer=new String[T];
		for(int i=0;i<T;i++) {
			n=sc.nextInt();
			map=new char[n][n];
			for(int j=0;j<n;j++) {
				String str=sc.next();
				for(int k=0;k<n;k++) {
					map[j][k]=str.charAt(k);
				}
			}
			
			if(checking()) answer[i]="YES";
			else answer[i]="NO";
		}
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
		
	}
}
