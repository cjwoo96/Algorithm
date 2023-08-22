package Swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		for (int tc = 0; tc < T; tc++) {
			sb.append("#" + (tc + 1) + " ");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				PQ.add(sc.nextInt());
			}
			while (!PQ.isEmpty()) {
				sb.append(PQ.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
