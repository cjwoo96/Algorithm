import java.util.Scanner;

public class Solution {
	static int[] plan;
	static int[] cost;
	static int min; // 최소값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			min = Integer.MAX_VALUE;
			cost = new int[4]; // 수영장 가격
			plan = new int[12]; // 수영 계획
			
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			
			dfs(0, 0);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	public static void dfs(int m, int total) {
		// m = month
		if (m > 11) {
			if (total < min) min = total;
			return;
		}
		
		if (plan[m] == 0) dfs(m+1,total);
		else {
			dfs(m+1, total+ cost[0]*plan[m]); //1일권
			dfs(m+1, total + cost[1]); // 한달권
			dfs(m+3, total + cost[2]); // 3달권
			dfs(m+12, total + cost[3]); // 일년권
		}
	}
}
