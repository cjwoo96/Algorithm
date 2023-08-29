

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
	
		
		
		Stack<Character> main=new Stack<>();
		Stack<Character> sub=new Stack<>();
		
		String str=br.readLine();
		
		String target=br.readLine();
		
		for(int i=0;i<str.length();i++) {
			main.add(str.charAt(i));
			//add
			if(main.peek()!=target.charAt(target.length()-1)) continue;
			else {
				for(int j=target.length()-1;j>=0;j--) {
					if(main.isEmpty()||main.peek()!=target.charAt(j)) {
						while(!sub.isEmpty()) {
							main.add(sub.pop());
						}
					}
					else sub.add(main.pop());
					
				}
				sub.clear();
			}
		}
		if(main.size()==0) System.out.println("FRULA");
		else {
			for(char c:main) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		
	}
}
