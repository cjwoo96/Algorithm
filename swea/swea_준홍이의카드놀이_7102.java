package Swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ÁØÈ«ÀÌÀÇÄ«µå³îÀÌ_7102 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			sb.append("#"+(tc+1)+" ");
			int n=sc.nextInt();
			int m=sc.nextInt();

			Queue<Integer> Q=new LinkedList<>();

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					Q.add(i + j);
				}
			}
			int[] cnt=new int[n+m+1];
			int size=Q.size();
			for(int i=0;i<size;i++) {
				cnt[Q.poll()]++;
			}
			int max=0;
			for(int i=0;i<cnt.length;i++) {
				if(cnt[i]>max) max=cnt[i];
			}
			for(int i=0;i<cnt.length;i++) {
				if(max==cnt[i]) sb.append(i+" ");
			}
			sb.append("\n");
		
		}
		System.out.println(sb);
	}
}
