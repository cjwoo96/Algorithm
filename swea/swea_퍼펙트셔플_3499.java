package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ∆€∆Â∆Æº≈«√_3499 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(st.nextToken());
		List<String> L1=new ArrayList<>();
		List<String> L2=new ArrayList<>();
		for(int tc=0;tc<T;tc++) {
			sb.append("#"+(tc+1)+" ");
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				if(i<(int)Math.round(n/2.0)) L1.add(st.nextToken());
				else L2.add(st.nextToken());
			}
			for(int i=0;i<n;i++) {
				if(i%2==0) {
					sb.append(L1.get(0)+" ");
					L1.remove(0);
				}else {
					sb.append(L2.get(0)+" ");
					L2.remove(0);
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
