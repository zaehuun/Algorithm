import java.util.*;
/*
30분 - Cheating : O
다 짜놓고 -1인 경우 처리를 어떻게 해야될지 고민하느라 시간쓰다가 그냥 답 봤다.
while문에서 무한루프 돌아서 에러날거라고 생각했는데(계속 사이즈가 2보다 커서)
아무리 곱해도 K보다 작은 경우는 pq에 한 개만 남나봄..? 좀 어이없군
*/
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int element : scoville) {
            pq.add(element);
        }
        while (pq.size() >= 2 && pq.peek() < K) {
            int s1 = pq.remove();
            int s2 = pq.remove();
            int mixed = s1 + 2 * s2;
            pq.add(mixed);
            answer++;
        }

        if (pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}