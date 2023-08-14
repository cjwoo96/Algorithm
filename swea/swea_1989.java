package Swea;

import java.util.Scanner;
// 투 포인터로 해결
public class _1989 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//테스트케이스 수 저장.
		int T=sc.nextInt();
		int[] answers=new int[T];
		for(int i=0;i<T;i++) {
			String str=sc.next();
			int len=str.length()-1;
			int lt=0;
			int rt=len;
			int answer=1;
			// 주어진 문자열이 홀수개 일때 가운데 문자는 확인할 필요 x -> lt<rt 인 경우 만족하지 않는 경우가 있는지만 확인
			while(lt<rt) {
				// lt와 rt의 인덱스에 있는 문자가 같은 경우 안쪽으로 좁혀오며 비교한다.  
				if(str.charAt(lt)==str.charAt(rt)) {
					lt++;
					rt--;
				}
				// 만족하지 않는 경우 answer=0 대입 후 break
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
