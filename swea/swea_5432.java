// �踷��� �ڸ��� D4 (Stack)
package Swea;

import java.util.Scanner;
import java.util.Stack;

public class _5432 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// ���� �� �Է�.
		int T=sc.nextInt();
		// ������ ������ �迭.
		int[] answers=new int[T];
		for(int tc=0;tc<T;tc++) {
			Stack<Character> stack=new Stack<>();
			String str=sc.next();
			int answer=0;
			//���ڿ��� �ϳ��� Ȯ��
			for(int i=0;i<str.length();i++) {
				//'('�� �Է����� ������ ������ add
				if(str.charAt(i)=='(') stack.add('(');
				// �� ���� ���.
				else {
					//()�� �������� �� ���̰�, )���� )�� �踷����� �� �κ��̱⿡ ������ ���
					stack.pop();
					// ���� ���ڿ� �ٷ� �ڰ� '('�� ��� �������� �� ���̹Ƿ� ���� stack���� '('�� ����ִµ� �̰��� ����ŭ �߸��Ƿ� ���û���� �����ش�.
					if(str.charAt(i-1)=='(') answer+=stack.size();
					// �踷����� ���̹Ƿ� +1�� ���ش�
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
