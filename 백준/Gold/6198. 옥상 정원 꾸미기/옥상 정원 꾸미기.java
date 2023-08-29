

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		long cnt=0;

		for(int i=0;i<n;i++) {
			// add 하는경우 -> 스택이 비어있거나, 스택의 peek가 
			if(stack.isEmpty()||stack.peek()>arr[i]) {
				stack.add(arr[i]);
			}
			else {
				while(!stack.isEmpty()&&stack.peek()<=arr[i]) {
					stack.pop();
				}
				stack.add(arr[i]);
			}
			cnt+=stack.size()-1;
		}
		System.out.println(cnt);
	}
}
