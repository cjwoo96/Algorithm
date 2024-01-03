
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[K];
		int[] dpr=new int[K];
		int[] dpl=new int[K];
		Arrays.fill(dpr,1);
		Arrays.fill(dpl,1);
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<K;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]&&dpr[i]<=dpr[j]) {
					dpr[i]=dpr[j]+1;
				}
			}
		}
		for(int i=K-2;i>=0;i--) {
			for(int j=i+1;j<K;j++) {
				if(arr[i]>arr[j]&&dpl[i]<=dpl[j]) {
					dpl[i]=dpl[j]+1;
				}
			}
		}
		
		int max=0;
		for(int i=0;i<K;i++) {
			max=Math.max(max, dpl[i]+dpr[i]);
		}
		System.out.println(max-1);
	}
}
