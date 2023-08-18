// D3 Stack
package Swea;

import java.util.Scanner;
import java.util.Stack;

public class _8931 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//테케개수 저장
		int T=sc.nextInt();
		//테케 만큼 for문 반복
		int[] answers=new int[T];
		for(int tc=0;tc<T;tc++) {
			Stack<Integer> stack=new Stack<>();
			int n=sc.nextInt();
			//for문이 다 돈후 남아 있는 수의 합을 저장할 변수
			int answer=0;
			for(int i=0;i<n;i++) {
				int p=sc.nextInt();
				if(p==0) {
					//0이면 stack.pop()을해주고 그 값을 answer에서 뺴줌.
					answer-=stack.pop();
					//0이 아니면 stack.add() 해주고 answer에다 그 값 더해줌 
				}else {
					answer+=p;
					stack.add(p);
				}
			}
			answers[tc]=answer;
		}
		// 출력 방식에 맞게 출력
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
	}
}
