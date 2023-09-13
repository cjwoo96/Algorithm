

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static void push(int val) {
		MinHeap.add(val);
		int idx = MinHeap.size() - 1;
		while (idx / 2 >= 1 && MinHeap.get(idx) < MinHeap.get(idx / 2)) {
			int temp = MinHeap.get(idx);
			MinHeap.set(idx, MinHeap.get(idx / 2));
			MinHeap.set(idx / 2, temp);
			idx /= 2;
		}
	}

	static int remove() {
		if (MinHeap.size() == 1)
			return 0;
		int removeNode = MinHeap.get(1);
		MinHeap.set(1, MinHeap.get(MinHeap.size() - 1));
		MinHeap.remove(MinHeap.size() - 1);
		int pos = 1;
		while (pos * 2 <= MinHeap.size() - 1) {
			int min = MinHeap.get(pos * 2);
			int minpos = pos * 2;
			if (pos * 2 + 1 <= MinHeap.size() - 1 && MinHeap.get(pos * 2 + 1) < MinHeap.get(pos * 2)) {
				min = MinHeap.get(pos * 2 + 1);
				minpos = pos * 2 + 1;
			}
			if (min > MinHeap.get(pos))
				break;

			MinHeap.set(minpos, MinHeap.get(pos));
			MinHeap.set(pos, min);
			pos = minpos;
		}
		return removeNode;
	}

	static ArrayList<Integer> MinHeap;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		MinHeap = new ArrayList<Integer>();
		MinHeap.add(0);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a == 0) {
				sb.append(remove()).append("\n");
			} else {
				push(a);
			}
		}
		System.out.println(sb);
	}
}
