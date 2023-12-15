
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int orderSize = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int countA = Integer.parseInt(st.nextToken());
		int countB = Integer.parseInt(st.nextToken());

		int[] arrA = new int[countA];
		int[] arrB = new int[countB];

		for (int i = 0; i < countA; i++) {
			st = new StringTokenizer(br.readLine());
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < countB; i++) {
			st = new StringTokenizer(br.readLine());
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		HashMap<Integer, Integer> A = new HashMap<>();
		HashMap<Integer, Integer> B = new HashMap<>();
		for (int i = 1; i < countA; i++) {
			for (int j = 0; j < countA; j++) {
				int sum = 0;
				for (int k = j; k < j + i; k++) {
					if (k < countA) {
						sum += arrA[k];
					} else {
						sum += arrA[k % countA];
					}
				}
				A.put(sum, A.getOrDefault(sum, 0) + 1);
			}
		}
		int sumA = 0;
		for (int i = 0; i < countA; i++) {
			sumA += arrA[i];
		}
		A.put(sumA, A.getOrDefault(sumA, 0) + 1);
		for (int i = 1; i < countB; i++) {
			for (int j = 0; j < countB; j++) {
				int sum = 0;
				for (int k = j; k < j + i; k++) {
					if (k < countB) {
						sum += arrB[k];
					} else {
						sum += arrB[k % countB];
					}
				}
				B.put(sum, B.getOrDefault(sum, 0) + 1);
			}
		}
		int sumB = 0;
		for (int i = 0; i < countB; i++) {
			sumB += arrB[i];
		}
		B.put(sumB, B.getOrDefault(sumB, 0) + 1);
		Set<Integer> AkeySet = A.keySet();
//		Set<Integer> BkeySet = B.keySet();
		int answer = 0;
//		for (Integer key : AkeySet) {
//			System.out.println("key : " + key + " Value : " + A.get(key));
//		}
//
//		System.out.println("================");
//
//		for (Integer key : BkeySet) {
//			System.out.println("key : " + key + " Value : " + B.get(key));
//		}

		for (Integer key : AkeySet) {
			int temp = orderSize - key;
			if (B.containsKey(temp)) {
				answer += A.get(key) * B.get(temp);
			}
		}
		if (A.containsKey(orderSize)) {
			answer += A.get(orderSize);
		}
		if (B.containsKey(orderSize)) {
			answer += B.get(orderSize);
		}
		System.out.println(answer);

	}
}
