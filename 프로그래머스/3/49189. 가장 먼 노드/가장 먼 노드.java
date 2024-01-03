import java.util.*;
class Solution {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int size=0;
    static void BFS(){
        Queue<Integer> Q=new LinkedList<>();
        Q.add(1);
        while(!Q.isEmpty()){
            size=Q.size();
            for(int i=0;i<size;i++){
                int k=Q.poll();
                for(int j=0;j<arr[k].size();j++){
                    int temp=arr[k].get(j);
                    if(visited[temp]) continue;
                    visited[temp]=true;
                    Q.add(temp);
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        arr=new ArrayList[n+1];
        visited=new boolean[n+1];
        visited[1]=true;
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            arr[edge[i][1]].add(edge[i][0]);
            arr[edge[i][0]].add(edge[i][1]);
        }
        BFS();
        return size;
        
    }
}