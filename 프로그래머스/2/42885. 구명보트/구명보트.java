import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int lt=0;
        int rt=people.length-1;
        int answer=0;
        while(lt<=rt){
            if(people[lt]+people[rt]<=limit) {
                rt--;
                lt++;
            }else rt--;
            answer++;
        }
        return answer;
    }
}