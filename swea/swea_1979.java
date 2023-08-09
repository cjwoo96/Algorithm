package practice_Git02;

import java.util.Scanner;

public class class02 {

	static int n,k;
	static int[][] arr,check;
	static int right() {
		check=new int[n][n];
		int answer=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-k+1;j++) {
				if(check[i][j]==1)continue;
				if(arr[i][j]==1) {
					int temp=1;
					check[i][j]=1;
					for(int l=1;l+j<n;l++) {
						if(arr[i][j+l]==1) {
							check[i][j+l]=1;
							temp++;
						}else break;
					}
					if(temp==k) answer++;
					
				}
			}
		}
		return answer;
	}
	static int down() {
		check=new int[n][n];
		int answer=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-k+1;j++) {
				if(check[j][i]==1)continue;
			
				if(arr[j][i]==1) {
					check[j][i]=1;
					int temp=1;
					for(int l=1;l+j<n;l++) {
						if(arr[j+l][i]==1) {
							check[j+l][i]=1;
							temp++;
							
						}else break;
					}
					if(temp==k) answer++;
					
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] answer= new int[T];
		for(int i=0;i<T;i++) {
			n=sc.nextInt();
			k=sc.nextInt();
			
			arr=new int[n][n];
			for(int j=0;j<n;j++) {
				for(int l=0;l<n;l++) {
					arr[j][l]=sc.nextInt();
				}
			}
			answer[i]=down()+right();
		}
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
	}
}
