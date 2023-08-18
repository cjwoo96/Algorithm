// 쇠막대기 자르기 D4 (Stack)
package Swea;

import java.util.Scanner;
import java.util.Stack;

public class _5432 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 테케 수 입력.
		int T=sc.nextInt();
		// 정답을 저장할 배열.
		int[] answers=new int[T];
		for(int tc=0;tc<T;tc++) {
			Stack<Character> stack=new Stack<>();
			String str=sc.next();
			int answer=0;
			//문자열을 하나씩 확인
			for(int i=0;i<str.length();i++) {
				//'('이 입력으로 들어오면 무조건 add
				if(str.charAt(i)=='(') stack.add('(');
				// 그 외의 경우.
				else {
					//()은 레이저를 쏜 것이고, )뒤의 )은 쇠막대기의 끝 부분이기에 나눠서 고려
					stack.pop();
					// 현재 문자열 바로 뒤가 '('일 경우 레이저를 쏜 것이므로 현재 stack에는 '('만 들어있는데 이것의 수만큼 잘리므로 스택사이즈를 더해준다.
					if(str.charAt(i-1)=='(') answer+=stack.size();
					// 쇠막대기의 끝이므로 +1을 해준다
					else answer++;
				}
			}
			answers[tc]=answer;
		}
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
	}
}
