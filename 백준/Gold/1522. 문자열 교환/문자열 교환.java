
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();

		int size = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a')
				size++;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = i; j < size + i; j++) {
				if (j >= str.length()) {
					int temp = j % str.length();
					if (str.charAt(temp) == 'a')
						count++;
				} else if (str.charAt(j) == 'a')
					count++;
			}
			min = Math.min(min, size - count);
		}

		System.out.println(min);

	}
}
