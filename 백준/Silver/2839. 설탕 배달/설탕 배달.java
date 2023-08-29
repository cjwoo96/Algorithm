//package Baekjune;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int answer=0;
		if(N%5==0) System.out.println(N/5);
		else {
			int a=N/5+1;
			int b=0;
			while(true) {
				a--;
				if(a<0) {
					answer=-1;
					break;
				}
				if((N-(5*a))%3==0) {
					answer=a+(N-(5*a))/3;
					break;
				}
			}
			System.out.println(answer);
		}
		
	}
}
