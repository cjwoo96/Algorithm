
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String S, T;
	static int sa, sb, ta, tb;
	static boolean flag;

	static void bfs(String str, int a, int b) {
		if (!flag)
			return;
		if (str.length() == S.length()) {
			if (str.equals(S)) {
				flag = false;
			}
		} else {
			if (b > sb && str.charAt(0) == 'B') {
				String nstr = "";
				for (int i = str.length() - 1; i > 0; i--) {
					nstr += str.charAt(i);
				}
				bfs(nstr, a, b - 1);
			}
			if (a > sa && str.charAt(str.length() - 1) == 'A') {
				bfs(str.substring(0, str.length() - 1), a - 1, b);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = st.nextToken();

		st = new StringTokenizer(br.readLine());
		T = st.nextToken();

		sa = 0;
		sb = 0;
		ta = 0;
		tb = 0;
		flag = true;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'A')
				sa++;
			else
				sb++;
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == 'A')
				ta++;
			else
				tb++;
		}
		bfs(T, ta, tb);
		if (!flag)
			System.out.println(1);
		else
			System.out.println(0);

	}
}
