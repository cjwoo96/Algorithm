import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int L,C;
	static ArrayList<String> List;
	static int[] check;
	static void Dfs_1759(int level,int st) {
		if(L==level) {
			int cnt=0;
			int cnt2=0;
			for(int i=0;i<C;i++) {
				if(check[i]==1) {
					if(List.get(i).equals("a")||List.get(i).equals("e")||List.get(i).equals("i")||List.get(i).equals("o")||List.get(i).equals("u")) cnt++;
					else cnt2++;
				}
			}
			if(cnt>=1&&cnt2>=2) {
				for(int i=0;i<C;i++) {
					if(check[i]==1) System.out.print(List.get(i));
				}
				System.out.println();
		}
	}
		else {
			for(int i=st;i<C;i++) {
				check[i]=1;
				Dfs_1759(level+1, i+1);
				check[i]=0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List = new ArrayList<>();
		L = sc.nextInt();
		C = sc.nextInt();
		check = new int[C];
		for (int i = 0; i < C; i++) {
			String s = sc.next();
			List.add(s);
		}

		Collections.sort(List);
		Dfs_1759(0, 0);

	}

}