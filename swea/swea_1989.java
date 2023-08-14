package Swea;

import java.util.Scanner;
// �� �����ͷ� �ذ�
public class _1989 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//�׽�Ʈ���̽� �� ����.
		int T=sc.nextInt();
		int[] answers=new int[T];
		for(int i=0;i<T;i++) {
			String str=sc.next();
			int len=str.length()-1;
			int lt=0;
			int rt=len;
			int answer=1;
			// �־��� ���ڿ��� Ȧ���� �϶� ��� ���ڴ� Ȯ���� �ʿ� x -> lt<rt �� ��� �������� �ʴ� ��찡 �ִ����� Ȯ��
			while(lt<rt) {
				// lt�� rt�� �ε����� �ִ� ���ڰ� ���� ��� �������� �������� ���Ѵ�.  
				if(str.charAt(lt)==str.charAt(rt)) {
					lt++;
					rt--;
				}
				// �������� �ʴ� ��� answer=0 ���� �� break
				else {
					answer=0;
					break;
				}
			}
			answers[i]=answer;
		}
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
	}
}
