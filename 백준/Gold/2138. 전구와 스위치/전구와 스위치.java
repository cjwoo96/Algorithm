
import java.util.Scanner;

public class Main {
	static char[] start;
	static char[] end;
	static void push(int x) {
		if(x-1>=0) {
			if(start[x-1]=='1') start[x-1]='0';
			else start[x-1]='1';
		}
		
		if(x+1<start.length){
			if(start[x+1]=='1') start[x+1]='0';
			else start[x+1]='1';
		}
		
		if(start[x]=='1') start[x]='0';
		else start[x]='1';
	
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String str=sc.next();
		String target=sc.next();
		
		start=str.toCharArray();
		end=target.toCharArray();
		
		int count1=0;
		for(int i=1;i<str.length();i++) {
			if(start[i-1]==end[i-1]) continue;
			push(i);
			count1++;
		}
		if(start[str.length()-1]!=end[str.length()-1]) count1=Integer.MAX_VALUE;
		
		start=str.toCharArray();
		
		push(0);
		int count2=1;
		for(int i=1;i<str.length();i++) {
			if(start[i-1]==end[i-1]) continue;
			push(i);
			count2++;
		}
		
		if(start[str.length()-1]!=end[str.length()-1]) count2=Integer.MAX_VALUE;
		
		int answer=Math.min(count1, count2);
		
		if(answer==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
		
	}
}
