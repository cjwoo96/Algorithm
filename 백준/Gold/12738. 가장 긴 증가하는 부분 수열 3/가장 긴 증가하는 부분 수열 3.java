
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int k=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		ArrayList<Integer> LIS=new ArrayList<>();
		LIS.add(Integer.parseInt(st.nextToken()));
		L : for(int i=1;i<k;i++) {
			int temp=Integer.parseInt(st.nextToken());
			int answer=-1;
			if(LIS.get(LIS.size()-1)<temp) LIS.add(temp);
			
			else {
				int rt=LIS.size()-1;
				int lt=0;
				while(lt<=rt) {
					int mid=(lt+rt)/2;
					if(temp==LIS.get(mid)) continue L;
					else if(temp<LIS.get(mid)) {
						answer=mid;
						rt=mid-1;
					}
					else {
						lt=mid+1;
					}
					
				}
				
					LIS.set(answer, temp);
				
				
			}
			
		}
		System.out.println(LIS.size());
	}
}
