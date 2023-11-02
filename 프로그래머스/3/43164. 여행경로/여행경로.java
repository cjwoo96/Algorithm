import java.util.*;
class Solution {
    static boolean[] visited;
	static ArrayList<String> list = new ArrayList<>();

	static void DFS(int L, String[][] tickets, String key, String str) {

		if (L == tickets.length - 1) {
			list.add(str);
		} else {
			for (int i = 0; i < tickets.length; i++) {
				if (!visited[i] && tickets[i][0].equals(key)) {
					visited[i] = true;
					DFS(L + 1, tickets, tickets[i][1], str + tickets[i][1]);
					visited[i] = false;
				}
			}
		}
	}
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				visited[i] = true;
				DFS(0, tickets, tickets[i][1], "ICN"+tickets[i][1]);
				visited[i] = false;
			}
		}
		Collections.sort(list);
		int len = list.get(0).length() / 3;
		String[] answer = new String[len];
		for (int i = 0; i < len; i++) {
			answer[i] = list.get(0).substring(i * 3, (i + 1) * 3);
		}
		return answer;
    }
}