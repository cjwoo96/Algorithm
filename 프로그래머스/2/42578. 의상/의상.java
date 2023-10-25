import java.util.*;
class Solution {
   
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        int mapSize=map.size();
        int answer=1;
        for(String key:map.keySet()){
            answer*=(1+map.get(key));
        }
        
        return answer-1;
    }
}