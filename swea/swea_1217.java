package Swea;

import java.util.Scanner;

public class _1217 {
	static int answer=0;
	static void sol(int ans,int L) {
		if(m==L) {
			answer=ans;
		}else {
			sol(ans*n,L+1);
		}
	}
	static int n,m;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] answers=new int[10];
		for(int tc=0;tc<10;tc++) {
			int T=sc.nextInt();
			n=sc.nextInt();
			m=sc.nextInt();
			sol(1,0);
			answers[tc]=answer;
		}
		for(int i=0;i<10;i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
	}
}
