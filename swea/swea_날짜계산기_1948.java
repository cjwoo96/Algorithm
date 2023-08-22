package swea;

import java.util.Scanner;

public class 날짜계산기_1948 {

	public static void main(String[] args) {
		int[] month= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] answers=new int[T];
		for(int i=0;i<T;i++) {
			int sm=sc.nextInt();
			int sd=sc.nextInt();
			int em=sc.nextInt();
			int ed=sc.nextInt();
			int answer=0;
			for(int j=sm;j<em;j++) {
				answer+=month[j];
			}
			answer=answer-sd+1+ed;
			answers[i]=answer;
		}
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
	}
}
