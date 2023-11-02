import java.util.*;
class Solution {
    static class line implements Comparable<line>{
        int from,to,value;
        public line(int from,int to,int value){
            this.from=from;
            this.to=to;
            this.value=value;
        }
        @Override
        public int compareTo(line o){
            return this.value-o.value;
        } 
    }
    static int find(int x){
        if(unionarr[x]==x) return x;
        return find(unionarr[x]);
    }
    static void Union(int a,int b){
        int ra=find(a);
        int rb=find(b);
        if(ra>rb) unionarr[ra]=rb;
        else unionarr[rb]=ra;
    }
    static int[] unionarr;
    public int solution(int n, int[][] costs) {
        ArrayList<line> arr=new ArrayList<>();
        
        for(int i=0;i<costs.length;i++){
            arr.add(new line(costs[i][0],costs[i][1],costs[i][2]));
        }
        Collections.sort(arr);
        unionarr=new int[n];
        
        for(int i=0;i<n;i++){
            unionarr[i]=i;
        }
        int answer=0;
        int cnt=0;
        for(int i=0;i<arr.size();i++){
            line temp=arr.get(i);
            if(find(temp.from)!=find(temp.to)){
                cnt++;
                answer+=temp.value;
                Union(temp.from,temp.to);
                if(cnt==n-1) break;
            }
        }
        return answer;
    }
}