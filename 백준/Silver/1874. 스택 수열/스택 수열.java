

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		Stack<Integer> stack=new Stack<>();
		List<Character> list=new ArrayList<>();
		int cnt=1;
		int idx=0;
		boolean flag=true;
		
		while(cnt<=n||!stack.isEmpty()) {
//		    if(cnt>n) {
//		    	flag=false;
//		    	break;
//		    }
			if(stack.isEmpty()||stack.peek()<arr[idx]) {
				stack.push(cnt++);
				list.add('+');
			}else {
				if(stack.pop()==arr[idx++]) {
					list.add('-');
				}else {
					flag=false;
					break;
				}
			}
		}
		if(flag) {
			for(char c:list) {
				System.out.println(c);
			}
		}else System.out.println("NO");
		
		
	}
}
