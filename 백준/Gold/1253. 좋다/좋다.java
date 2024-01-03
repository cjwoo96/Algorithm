
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);

		HashMap<Integer, Boolean> map = new HashMap<>();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (map.containsKey(list.get(i))) {
				if (map.get(list.get(i)))
					answer++;
				continue;
			}
			int lt = 0;
			if (i == 0)
				lt++;
			int rt = N - 1;
			if (rt == i)
				rt--;
			while (lt < rt) {
				if (list.get(lt) + list.get(rt) == list.get(i)) {
					answer++;
					map.put(list.get(i), true);
					break;
				} else if (list.get(lt) + list.get(rt) < list.get(i)) {
					lt++;
					if (lt == i)
						lt++;
				} else {
					rt--;
					if (rt == i)
						rt--;
				}
			}
			if (!map.containsKey(list.get(i)))
				map.put(list.get(i), false);
		}

		System.out.println(answer);
	}
}
