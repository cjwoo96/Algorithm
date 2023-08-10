package practice_Git02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1974 {

	static int[][] arr;
	static boolean rowcolumn(int r) {
		List<Integer> list1=new ArrayList<>();
		List<Integer> list2=new ArrayList<>();
		for(int i=0;i<9;i++) {
			if(list1.contains(arr[i][r])) return false; 
			else list1.add(arr[i][r]);
			
			if(list2.contains(arr[r][i])) return false; 
			else list2.add(arr[r][i]);
		}
		return true;
	}
	static boolean TtoT() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				List<Integer> list=new ArrayList<>();
				for(int k=3*i;k<3*i+3;k++) {
					for(int l=3*j;l<3*j+3;l++) {
						if(list.contains(arr[k][l])) return false;
						else list.add(arr[k][l]);
					}
				}
			}
		}
		return true;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		int[] answer=new int[T];
		for(int i=0;i<T;i++) {
			arr=new int[9][9];
			for(int j=0;j<9;j++) {
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<9;k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());
				}
				
			}
			boolean flag=true;
			for(int j=0;j<9;j++) {
				if(!(rowcolumn(j))) {
					flag=false;
					break;
				}
			}
			if(flag) {
				if(TtoT()) answer[i]=1;
				else answer[i]=0;
			}else answer[i]=0;
			
		}
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
	}
}
