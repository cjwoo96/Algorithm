import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		String str=sc.next();
		char[] c=str.toCharArray();
		int cnt=0;
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<n;i++) {
//			System.out.println(stack);
			if(!stack.isEmpty()&&stack.peek()<c[i]-'0'&&cnt<k) {
				stack.pop();
				cnt++;
				while(!stack.isEmpty()&&cnt<k) {
					if(stack.peek()<c[i]-'0') {
						stack.pop();
						cnt++;
					}
					else break;
				}
			}
			stack.push(c[i]-'0');
			
		}
		if(cnt<k) {
			for(int i=0;i<k-cnt;i++) stack.pop();
		}
		for(int x:stack) {
			System.out.print(x);
		}
	}
}