
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int answer=0;
			while(num>=0) {
				answer+=num/2+1;
				num-=3;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
}
