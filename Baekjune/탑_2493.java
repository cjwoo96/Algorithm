//Å¾ °ñµå5
package Baekjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		Stack<Integer> stack=new Stack<>();
		int n=Integer.parseInt(st.nextToken());
		int[] arr=new int[n];
		int[] check=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		int len=arr.length-1;
		for(int i=len;i>=0;i--) {
			if(stack.isEmpty()||stack.peek()>arr[i]) {
				stack.add(arr[i]);
			}else {
				cnt=i;
				while(!stack.isEmpty()) {
					if(stack.peek()<=arr[i]) {
						stack.pop();
						cnt++;
						check[cnt]=i+1;
					}else break;
				}
				stack.add(arr[i]);
			}
		}
		for(int x: check) {
			sb.append(x+" ");
		}
		System.out.println(sb);
	}
}
