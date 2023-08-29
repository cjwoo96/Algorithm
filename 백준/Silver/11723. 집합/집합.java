
//remove(int index)
//remove() 메소드의 파라미터로 int를 전달하면,
//해당 index의 값이 삭제됩니다.
//
// 
//remove(Object o)
//
//remove() 메소드의 파라미터로 Object 객체를 전달하면,
//
//ArrayList에서 해당 객체를 찾아서
//
//첫번째로 나오는 값만 삭제합니다.
//
//그리고, 값을 삭제하면 true를 리턴하고,
//
//만약 삭제할 값이 없으면 false를 리턴합니다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	
	static ArrayList<Integer> S=new ArrayList<>();
	
	static void add(int x) {
		if(!S.contains(x)) S.add(x);
	}
	static void remove(int x) {
		S.remove(Integer.valueOf(x));
	}
	static void check(int x) {
		if(!S.contains(x)) sb.append(0).append("\n");
		else sb.append(1).append("\n");
	}
	static void toggle(int x) {
		if (S.contains(x)) S.remove(Integer.valueOf(x));
		else S.add(x);
	}
	static void all() {
		S.clear();
		for(int i=1;i<=20;i++) {
			S.add(i);
		}
	}
	static void empty() {
		S.clear();
	}
	static String str;
	static int nx;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		int M=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			str=st.nextToken();
			if(st.hasMoreTokens()) nx=Integer.parseInt(st.nextToken());
			if(str.equals("add")) add(nx);
			else if(str.equals("check")) check(nx);
			else if(str.equals("remove")) remove(nx);
			else if(str.equals("all")) all();
			else if(str.equals("empty")) empty();
			else if(str.equals("toggle")) toggle(nx);
		}
		System.out.println(sb);

	}

}
