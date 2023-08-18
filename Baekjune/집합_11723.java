package Baekjune;
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

public class 집합_11723 {

	// 공집합 S 선언.
	static ArrayList<Integer> S=new ArrayList<>();
	
	// add 메서드 선언. 
	static void add(int x) {
		if(!S.contains(x)) S.add(x);
	}
	// remove 선언
	// List의 경우 index로 제거 하려면 remove 메서드 안에 int형 인덱스를 넣어주면 되지만
	// 값으로 제거를 하는 경우, Object를 넣어줘야 함. -> x라는 값으로 지우기 위해 Integer라는 wrapper클래스로 x를 넣어줌
	static void remove(int x) {
		S.remove(Integer.valueOf(x));
	}
	// 값을 출력하는 메서드. 문제에서 연산의 수가 최대 300만이므로 sysout을 300번 호출하면 시간적 낭비가 심하므로 sb에 모아서 출력
	static void check(int x) {
		if(!S.contains(x)) sb.append(0).append("\n");
		else sb.append(1).append("\n");
	}
	// toggle 메서드
	static void toggle(int x) {
		if (S.contains(x)) S.remove(Integer.valueOf(x));
		else S.add(x);
	}
	// all 메서드
	static void all() {
		S.clear();
		for(int i=1;i<=20;i++) {
			S.add(i);
		}
	}
	// empty 메서드
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
