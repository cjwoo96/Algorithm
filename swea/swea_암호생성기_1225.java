package Swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기_1225 {

	static int cnd;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			int n = sc.nextInt();
			sb.append("#" + n + " ");
			Queue<Integer> Q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				Q.add(sc.nextInt());
			}
			int d = 1;
			while (true) {
				cnd = Q.poll() - d;
				if (cnd < 0)
					cnd = 0;
				Q.offer(cnd);
				if (cnd == 0)
					break;

				d++;
				if (d == 6)
					d = 1;
			}
			while (!Q.isEmpty()) {
				sb.append(Q.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
