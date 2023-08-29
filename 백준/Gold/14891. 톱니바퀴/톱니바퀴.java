


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<char []> list=new ArrayList<>();
	static char[] c1,c2,c3,c4;
	static int[] check=new int[4];
	static void Switch(int n, int dir) {
		char[] sw=new char[8];
		if(dir==1) {
			for(int i=0;i<8;i++) {
				if(i==7) sw[0]=list.get(n)[i];
				else sw[i+1]=list.get(n)[i];
			}
		}else {
			for(int i=0;i<8;i++) {
				if(i==0) sw[7]=list.get(n)[i];
				else sw[i-1]=list.get(n)[i];
			}
		}
		list.set(n,sw);
	}
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		c1=sc.next().toCharArray();
		c2=sc.next().toCharArray();
		c3=sc.next().toCharArray();
		c4=sc.next().toCharArray();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		int n=sc.nextInt();
	
		for(int i=0;i<n;i++) {
			
			int num=sc.nextInt()-1;
			int dir=sc.nextInt();
			check[num]=1;
			
			for(int j=1;j<=3;j++) {
				int nx=num+j;
				if(nx<=3&&list.get(nx-1)[2]!=list.get(nx)[6]) {
					check[nx]=1;
				}else break;
			}
			
			for(int j=1;j<=3;j++) {
				int nx=num-j;
				if(nx>=0&&list.get(nx+1)[6]!=list.get(nx)[2]) {
					check[nx]=1;
				}else break;
			}

			for(int j=0;j<4;j++) {
				
				if(check[j]==1) {
					
					if(Math.abs(j-num)%2==0) Switch(j,dir);
					else Switch(j,-dir);
					 
				}
			}
			check=new int[4];
		}
		int answer=0;
		int point=1;
		for(int i=0;i<4;i++) {
			if(list.get(i)[0]=='1') {
				if(i==0) answer+=1;
				else if(i==1) answer+=2;
				else if(i==2) answer+=4;
				else answer+=8;
			}
		}
		System.out.println(answer);
	}
}
