package Baekjune;
//remove(int index)
//remove() �޼ҵ��� �Ķ���ͷ� int�� �����ϸ�,
//�ش� index�� ���� �����˴ϴ�.
//
// 
//remove(Object o)
//
//remove() �޼ҵ��� �Ķ���ͷ� Object ��ü�� �����ϸ�,
//
//ArrayList���� �ش� ��ü�� ã�Ƽ�
//
//ù��°�� ������ ���� �����մϴ�.
//
//�׸���, ���� �����ϸ� true�� �����ϰ�,
//
//���� ������ ���� ������ false�� �����մϴ�.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ����_11723 {

	// ������ S ����.
	static ArrayList<Integer> S=new ArrayList<>();
	
	// add �޼��� ����. 
	static void add(int x) {
		if(!S.contains(x)) S.add(x);
	}
	// remove ����
	// List�� ��� index�� ���� �Ϸ��� remove �޼��� �ȿ� int�� �ε����� �־��ָ� ������
	// ������ ���Ÿ� �ϴ� ���, Object�� �־���� ��. -> x��� ������ ����� ���� Integer��� wrapperŬ������ x�� �־���
	static void remove(int x) {
		S.remove(Integer.valueOf(x));
	}
	// ���� ����ϴ� �޼���. �������� ������ ���� �ִ� 300���̹Ƿ� sysout�� 300�� ȣ���ϸ� �ð��� ���� ���ϹǷ� sb�� ��Ƽ� ���
	static void check(int x) {
		if(!S.contains(x)) sb.append(0).append("\n");
		else sb.append(1).append("\n");
	}
	// toggle �޼���
	static void toggle(int x) {
		if (S.contains(x)) S.remove(Integer.valueOf(x));
		else S.add(x);
	}
	// all �޼���
	static void all() {
		S.clear();
		for(int i=1;i<=20;i++) {
			S.add(i);
		}
	}
	// empty �޼���
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
