// D3 Stack
package Swea;

import java.util.Scanner;
import java.util.Stack;

public class _8931 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//���ɰ��� ����
		int T=sc.nextInt();
		//���� ��ŭ for�� �ݺ�
		int[] answers=new int[T];
		for(int tc=0;tc<T;tc++) {
			Stack<Integer> stack=new Stack<>();
			int n=sc.nextInt();
			//for���� �� ���� ���� �ִ� ���� ���� ������ ����
			int answer=0;
			for(int i=0;i<n;i++) {
				int p=sc.nextInt();
				if(p==0) {
					//0�̸� stack.pop()�����ְ� �� ���� answer���� ����.
					answer-=stack.pop();
					//0�� �ƴϸ� stack.add() ���ְ� answer���� �� �� ������ 
				}else {
					answer+=p;
					stack.add(p);
				}
			}
			answers[tc]=answer;
		}
		// ��� ��Ŀ� �°� ���
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
	}
}
