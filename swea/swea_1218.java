// ��ȣ ¦���� D4 (Stack)
package Swea;

import java.util.Scanner;
import java.util.Stack;

public class _1218 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// ���ɰ� 10���̹Ƿ� 1~10���� ���� �����ϱ� ���� ������ 11�� ����.
		int[] answers=new int[11];
		// ���� �� ��ŭ �ݺ��� �ݺ�
		for(int tc=1;tc<=10;tc++) {
			// ���� ����.
			Stack<Character> stack=new Stack<>();
			int n=sc.nextInt();
			String str=sc.next();
			// �⺻�����δ� ��ȿ���� ��Ÿ���� 1�� �ʱ�ȭ
			int answer=1;
			// �Է¹��� ���ڿ��� ���̸�ŭ �ݺ�
			for(int i=0;i<str.length();i++) {
				// ��ȣ�� �����ϴ� �κ��� �ԷµǸ� ������ add
				if(str.charAt(i)=='<'||str.charAt(i)=='{'||str.charAt(i)=='('||str.charAt(i)=='[') {
					stack.add(str.charAt(i));
			}else {
				// ��ȣ�� �ݾƾ� �ϴµ� ������ ������� answer=0���� �ϰ� break ��ȿ���� �ʴ� ���
				if(stack.isEmpty()) {
					answer=0;
					break;
				}
				// stack�� ���� �ʾҴٸ� �켱 char ������ ���� �ֻ�ܰ� �̾Ƽ� ����.
				char c=stack.pop();
				// ¦�� �°� ���°����� Ȯ�� �� ������ continue �ƴϸ� break
				if((c=='('&&str.charAt(i)==')')||(c=='<'&&str.charAt(i)=='>')||(c=='{'&&str.charAt(i)=='}')||(c=='['&&str.charAt(i)==']')) continue;
				else {
					answer=0;
					break;
				}
			}
			}
			answers[tc]=answer;
			
		}
		// ������Ŀ� �°� ���
		for(int i=1;i<=10;i++) {
			System.out.println("#"+i+" "+answers[i]);
		}
	}
}
