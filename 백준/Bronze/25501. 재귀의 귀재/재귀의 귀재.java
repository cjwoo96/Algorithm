import java.util.Scanner;

public class Main {
	static int flag = 1; // 회문 여부
	static int cnt = 0; // 재귀 호출 횟수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			String s = sc.next();
			
			recur(s, 0, s.length()-1);
			
			System.out.printf("%d %d\n", flag, cnt);
			
			flag = 1;
			cnt = 0; // 초기화
		}
	}
	
	public static void recur(String s, int st, int ed) {
		cnt++;
		
		// st가 ed를 넘어서면 return
		if (st >= ed) return;
		
		// 회문이 아니면 flag = 0 으로 바꾸고 return
		if (s.charAt(st) != s.charAt(ed)) {
			flag = 0;
			return;
		}
		
		// 재귀 파트
		recur(s, st+1, ed-1);
		
	}
}
