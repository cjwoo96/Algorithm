import java.util.ArrayList;
class Solution {
 
	static int answer = Integer.MIN_VALUE;
	static ArrayList<Integer>[] arr;

	static void DFS(ArrayList<Integer> list, int sheep, int wolf, int nextnode,int[] info, int[][] edges) {
		if (info[nextnode] == 0)
			sheep++;
		else
			wolf++;
        answer = Math.max(answer, sheep);
		if (sheep == wolf || list.isEmpty()) return;
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i));
		}
		list2.remove(Integer.valueOf(nextnode));

		for (int i = 0; i < arr[nextnode].size(); i++) {
			list2.add(arr[nextnode].get(i));
		}

		for (int i = 0; i < list2.size(); i++) {
			DFS(list2, sheep, wolf, list2.get(i),info,edges);
		}

	}
    public int solution(int[] info, int[][] edges) {
       arr = new ArrayList[info.length];
		for (int i = 0; i < info.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			arr[edges[i][0]].add(edges[i][1]);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		DFS(list, 0, 0, 0,info,edges);
		return answer;
    }
}