

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> MaxHeap;

	static void push(int val) {
		MaxHeap.add(val);
		int idx = MaxHeap.size() - 1;
		while (idx / 2 >= 1 && MaxHeap.get(idx) > MaxHeap.get(idx / 2)) {
			int temp = MaxHeap.get(idx);
			MaxHeap.set(idx, MaxHeap.get(idx / 2));
			MaxHeap.set(idx / 2, temp);
			idx /= 2;
		}

	}

	static int remove() {
		if (MaxHeap.size() == 1)
			return 0;
		int removeNode = MaxHeap.get(1);
		MaxHeap.set(1, MaxHeap.get(MaxHeap.size() - 1));
		MaxHeap.remove(MaxHeap.size() - 1);

		int pos = 1;
		while (pos * 2 <= MaxHeap.size() - 1) {
			int max;
			int maxpos;
			if (pos * 2 + 1 <= MaxHeap.size() - 1 && MaxHeap.get(pos * 2) < MaxHeap.get(pos * 2 + 1)) {
				max = MaxHeap.get(pos * 2 + 1);
				maxpos = pos * 2 + 1;
			} else {
				max = MaxHeap.get(pos * 2);
				maxpos = pos * 2;
			}
			if (max < MaxHeap.get(pos))
				break;

			MaxHeap.set(maxpos, MaxHeap.get(pos));
			MaxHeap.set(pos, max);
			pos = maxpos;
		}
		return removeNode;
	}

	public static void main(String[] args) {
		MaxHeap = new ArrayList<Integer>();
		MaxHeap.add(0);
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
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
