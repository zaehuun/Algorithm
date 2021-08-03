
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sc : scoville) pq.offer(sc);
        while(pq.size() != 0){
            int first = pq.poll();
            if(first >= K) return answer;
            if (pq.size() == 0 && first < K) return -1;
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer += 1;
        }
        return answer;
    }
}
