import java.util.*;
/*
20분 - Cheating : X
Arrays.sort -> 시초
*/
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqRev = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<A.length; i++) {
            pq.add(A[i]);
            pqRev.add(B[i]);
        }
        while (!pq.isEmpty()) {
            answer += pq.poll() * pqRev.poll();
        }
        return answer;
    }
}