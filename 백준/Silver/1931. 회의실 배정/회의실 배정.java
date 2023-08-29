

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class room implements Comparable<room>{
	long st;
	long lt;
	public room(long st,long lt) {
		this.st=st;
		this.lt=lt;
	}
	@Override
	public int compareTo(room o) {
		// TODO Auto-generated method stub
		if(this.lt>o.lt) return -1;
		else if(this.lt==o.lt) {
			if (this.st>o.st) return -1;
			else return 1;
		}
		else return 1;
	}
}
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		ArrayList<room> list=new ArrayList<>();
		for(int i=0;i<T;i++) {
			long a=sc.nextInt();
			long b=sc.nextInt();
			list.add(new room(a,b));
		}
		Collections.sort(list);
		int cnt=1;
		room p=list.get(0);
		for(int i=1;i<T;i++) {
			if(p.st>=list.get(i).lt) {
				p=list.get(i);
				cnt++;
			}else {
				if(p.st<list.get(i).st) p=list.get(i);
			}
		}
		System.out.println(cnt);
	}
}
