//파이썬에서는 맥스 힙 구현을 위해 값을 넣을 때 -1을 곱해서 저장했는데 자바는 그럴 필요가 없어서 좋은 거 같다.
import java.util.*;
class Solution {
    public PriorityQueue<Integer> pqToRpq(PriorityQueue<Integer> pq){
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : pq)
            rpq.offer(p);
        return rpq;
    }
    
    public PriorityQueue<Integer> rpqToPq(PriorityQueue<Integer> rpq){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int p : rpq)
            pq.offer(p);
        return pq;
    }
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        for(String op : operations){
            String[] sp = op.split(" ");
            String c = sp[0];
            String v = sp[1];
            if(c.equals("I")){
                pq.offer(Integer.parseInt(v));
                rpq.offer(Integer.parseInt(v));
            }
            else{
                if(pq.isEmpty()) continue;
                if(v.equals("1")){
                    rpq.poll();
                    pq = rpqToPq(rpq);
                }
                else{
                    pq.poll();
                    rpq = pqToRpq(pq);
                }
            }
        }
        if(pq.isEmpty()) return answer;
        else{
            answer[0] = rpq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}
