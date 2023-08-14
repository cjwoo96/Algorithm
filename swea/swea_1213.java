package Swea;

import java.util.Scanner;

public class _1213 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 답을 저장할 answer배열 선언
		int[] answers=new int[11];
		// 테케만큼 for문 반복.
		for(int tc=0;tc<10;tc++) {
			int n=sc.nextInt();
			String target=sc.next();
			String str=sc.next();
			int cnt=0;
			int len=target.length();
			// 주어진 str문자열을 앞에서 부터 순환하다가 target문자열의 0번 인덱스와 일치하는 문자가 나오면 그때부터 target문자열의 길이 -1 만큼 확인/
			l1 : for(int i=0;i<str.length();i++) {
				// target문자열의 0번 인덱스와 일치하는 문자가 있을 때
				if(str.charAt(i)==target.charAt(0)) {
					//이미 0번 인덱스는 비교했으므로 1번부터 len까지 비교.
					for(int j=1;j<len;j++) {
						// j+i가 범위를 넘어가지 않고 target문자열과 같을떄 continue
						if(j+i<str.length()&&target.charAt(j)==str.charAt(j+i)) continue;
						else continue l1;
					}
					//for문을 다도는 동안 else문에 걸리지 않으면 타겟 문자열이 포함되어 있는 것이므로 cnt를 증가시킨다. 
					cnt++;
				}
				
			}
			answers[n]=cnt;
		}
		for(int i=1;i<=10;i++) {
			System.out.println("#"+i+" "+answers[i]);
		}
	}
}
