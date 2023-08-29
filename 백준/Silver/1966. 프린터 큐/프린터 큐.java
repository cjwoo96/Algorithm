

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class A{
	int num;
	int value;
	public A(int num,int value) {
		this.num=num;
		this.value=value;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] answer=new int[T];
		for(int i=0;i<T;i++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			Integer[] arr=new Integer[n];
			ArrayList<Integer> list=new ArrayList<>();
			Queue<A> Q=new LinkedList<A>();
			for(int j=0;j<n;j++) {
				int value=sc.nextInt();
				Q.add(new A(j,value));
				list.add(value);
			}
			Collections.sort(list,Collections.reverseOrder());
			int idx=0;
			while(!Q.isEmpty()) {
				if(Q.peek().value==list.get(idx)) {
					idx++;
					if(Q.poll().num==m) {
						break;
					}
				}else Q.offer(Q.poll());
			}
			answer[i]=idx;
		}

		for(int x:answer) {
			System.out.println(x);
		}
	}

}
