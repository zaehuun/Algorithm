import java.util.*;
/*
43분 - Cheating : X
PQ에 자꾸 객체 add 해서 에러 고치느라 시간 다씀 ㅎㅋㅎㅋ.
*/
class Solution {
    static class NumInfo {
        int idx;
        int num;
        NumInfo (int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<NumInfo> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<priorities.length; i++) {
            NumInfo n = new NumInfo(i, priorities[i]);
            q.offer(n);
            pq.offer(priorities[i]);
        }
        int[] order = new int[priorities.length];
        int n = 1;
        while (!q.isEmpty()) {
            NumInfo qPeek = q.peek();
            int pqPeek = pq.peek();

            if (qPeek.num == pqPeek) {
                NumInfo qRemove = q.remove();
                pq.remove();
                order[qRemove.idx] = n;
                n++;
            }
            else if (qPeek.num != pqPeek) {
                q.poll();
                q.add(qPeek);
            }
        }
        return order[location];
    }
}