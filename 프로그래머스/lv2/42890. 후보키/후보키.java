import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static HashSet<String> set = new HashSet<>();
	static ArrayList<String> list = new ArrayList<>();

	static void DFS(int idx, int k, int L, String[][] relation) {
		if (k == L) {
			for (int i = 0; i < relation[0].length; i++) {
				if (check[i])
					sb.append(i);
			}

			if (list.size() != 0) {
				L: for (int i = 0; i < list.size(); i++) {
					boolean flag = true;
					for (int j = 0; j < list.get(i).length(); j++) {
						if (sb.toString().contains(list.get(i).substring(j, j + 1)))
							continue;
						else {
							flag = false;
							break;
						}
					}
					if (flag) {
						sb.setLength(0);
						return;
					}
				}

			}

			for (int i = 0; i < relation.length; i++) {
				for (int j = 0; j < sb.length(); j++) {
					sb2.append(relation[i][Integer.parseInt(sb.substring(j, j + 1))]);
				}
				set.add(sb2.toString());
				sb2.setLength(0);
			}

			if (set.size() == relation.length) {
				list.add(sb.toString());
			}
			sb.setLength(0);
			set.clear();

		} else {
			for (int i = idx; i < relation[0].length; i++) {
				check[i] = true;
				DFS(i + 1, k, L + 1, relation);
				check[i] = false;
			}
		}
	}
    public int solution(String[][] relation) {
        check = new boolean[relation[0].length];
        for (int i = 1; i <= relation[0].length; i++) {
			DFS(0, i, 0, relation);
		}
		return list.size();
    }
}