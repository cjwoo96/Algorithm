package Swea;

import java.util.Scanner;

public class _1213 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// ���� ������ answer�迭 ����
		int[] answers=new int[11];
		// ���ɸ�ŭ for�� �ݺ�.
		for(int tc=0;tc<10;tc++) {
			int n=sc.nextInt();
			String target=sc.next();
			String str=sc.next();
			int cnt=0;
			int len=target.length();
			// �־��� str���ڿ��� �տ��� ���� ��ȯ�ϴٰ� target���ڿ��� 0�� �ε����� ��ġ�ϴ� ���ڰ� ������ �׶����� target���ڿ��� ���� -1 ��ŭ Ȯ��/
			l1 : for(int i=0;i<str.length();i++) {
				// target���ڿ��� 0�� �ε����� ��ġ�ϴ� ���ڰ� ���� ��
				if(str.charAt(i)==target.charAt(0)) {
					//�̹� 0�� �ε����� �������Ƿ� 1������ len���� ��.
					for(int j=1;j<len;j++) {
						// j+i�� ������ �Ѿ�� �ʰ� target���ڿ��� ������ continue
						if(j+i<str.length()&&target.charAt(j)==str.charAt(j+i)) continue;
						else continue l1;
					}
					//for���� �ٵ��� ���� else���� �ɸ��� ������ Ÿ�� ���ڿ��� ���ԵǾ� �ִ� ���̹Ƿ� cnt�� ������Ų��. 
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
