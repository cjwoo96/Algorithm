// 괄호 짝짓기 D4 (Stack)
package Swea;

import java.util.Scanner;
import java.util.Stack;

public class _1218 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// 테케가 10개이므로 1~10까지 값을 저장하기 위해 사이즈 11로 선언.
		int[] answers=new int[11];
		// 테케 수 만큼 반복문 반복
		for(int tc=1;tc<=10;tc++) {
			// 스택 생성.
			Stack<Character> stack=new Stack<>();
			int n=sc.nextInt();
			String str=sc.next();
			// 기본적으로는 유효함을 나타내는 1로 초기화
			int answer=1;
			// 입력받은 문자열의 길이만큼 반복
			for(int i=0;i<str.length();i++) {
				// 괄호가 시작하는 부분이 입력되면 무조건 add
				if(str.charAt(i)=='<'||str.charAt(i)=='{'||str.charAt(i)=='('||str.charAt(i)=='[') {
					stack.add(str.charAt(i));
			}else {
				// 괄호를 닫아야 하는데 스택이 비었으면 answer=0으로 하고 break 유효하지 않는 경우
				if(stack.isEmpty()) {
					answer=0;
					break;
				}
				// stack이 비지 않았다면 우선 char 변수에 스택 최상단값 뽑아서 저장.
				char c=stack.pop();
				// 짝에 맞게 들어온것인지 확인 후 맞으면 continue 아니면 break
				if((c=='('&&str.charAt(i)==')')||(c=='<'&&str.charAt(i)=='>')||(c=='{'&&str.charAt(i)=='}')||(c=='['&&str.charAt(i)==']')) continue;
				else {
					answer=0;
					break;
				}
			}
			}
			answers[tc]=answer;
			
		}
		// 출력형식에 맞게 출력
		for(int i=1;i<=10;i++) {
			System.out.println("#"+i+" "+answers[i]);
		}
	}
}
