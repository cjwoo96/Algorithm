
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int k=Integer.parseInt(st.nextToken());
		int[] arr=new int[k];
		int[] dp=new int[k];
		int[] point=new int[k];
		
		Arrays.fill(dp, 1);
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<k;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int maxIndex=1;
		int EndIdx=0;
		for(int i=1;i<k;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]&&dp[i]<=dp[j]) {
					dp[i]=dp[j]+1;
					point[i]=j;
					if(maxIndex<dp[i]) {
						maxIndex=dp[i];
						EndIdx=i;
					}
				}
			}
		}
		System.out.println(maxIndex);
		int[] answer=new int[maxIndex];
		for(int i=1;i<=maxIndex;i++) {
			answer[i-1]=arr[EndIdx];
			EndIdx=point[EndIdx];
		}
		for(int i=maxIndex-1;i>=0;i--) {
			System.out.print(answer[i]+" ");
		}
	}
}
