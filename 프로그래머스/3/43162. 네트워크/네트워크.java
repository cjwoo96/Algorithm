import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static void BFS(int x){
        Queue<Integer> Q=new LinkedList<>();
        Q.add(x);
        while(!Q.isEmpty()){
            int k=Q.poll();
            for(int i=0;i<arr[k].size();i++){
                int temp=arr[k].get(i);
                if(visited[temp]) continue;
                visited[temp]=true;
                Q.add(temp);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        arr=new ArrayList[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==1) arr[i].add(j);
            }
        }
        int cnt=1;
        visited[0]=true;
        BFS(0);
        for(int i=1;i<n;i++){
            if(!visited[i]){
                cnt++;
                BFS(i);
            }
        }
        return cnt;
    }
}