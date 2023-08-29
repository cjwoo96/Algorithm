

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> Stack1=new Stack<>();
		Stack<Integer> Stack2=new Stack<>();
		int[] arr=new int[n+1];
		int[] check=new int[n+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			if(Stack1.isEmpty()) {
				sb.append("0 ");
				Stack1.add(arr[i]);
				Stack2.add(i);
			}
			else if(Stack1.peek()<arr[i]) {
				while(!Stack1.isEmpty()) {
					if(Stack1.peek()<arr[i]) {
						Stack1.pop();
						Stack2.pop();
					}else break;
				}
				if(Stack1.isEmpty()) sb.append("0 ");
				else sb.append(Stack2.peek()+" ");
				Stack1.add(arr[i]);
				Stack2.add(i);
			}
			else {
				sb.append(Stack2.peek()+" ");
				Stack1.add(arr[i]);
				Stack2.add(i);
			}
		}
		
		System.out.println(sb);
	}
}
