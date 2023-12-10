
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class point{
		int time, dir;

		public point(int time, int dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int e=sc.nextInt();
		if(s==e) {
			System.out.println(0);
			System.exit(0);
		}
		
		int[] map=new int[200001];
		
		boolean[] visited=new boolean[200001];
		visited[s]=true;
		boolean flag=false;
		Queue<point> Q=new LinkedList<>();
		Q.add(new point(0,s));
		int answer=Integer.MAX_VALUE;
		while(!Q.isEmpty()) {
			point p=Q.poll();
			for(int i=0;i<3;i++) {
				int ndir=-1;
				if(i==2) {
					ndir=p.dir+1;
					if(ndir>e) continue;
				}
				if(i==1) {
					ndir=p.dir-1;
				}
				if(i==0&&p.dir<e) {
					ndir=p.dir*2;
				}
				if(ndir>=0&&ndir<=200000&&!visited[ndir]) {
					
					if(ndir==e) {
						if(i==0) answer=Math.min(answer, p.time);
						else answer=Math.min(answer, p.time+1);
						flag=true;
					}
					
					visited[ndir]=true;
					
					if(flag) continue;
					
					if(i==0) Q.add(new point(p.time,ndir));
					else Q.add(new point(p.time+1,ndir));
				}
			}
		}
		
		System.out.println(answer);
	}

}
