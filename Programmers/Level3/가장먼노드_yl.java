import java.util.*;
/*
45분 - Cheating : X
*/
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        int[] dist = new int[n+1];
        Arrays.fill(dist, 50001);
        dist[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i=0; i<edge.length; i++) {
                if (edge[i][0] == cur && dist[edge[i][1]] == 50001) {
                    dist[edge[i][1]] = dist[edge[i][0]] + 1;
                    q.add(edge[i][1]);
                }
                else if (edge[i][1] == cur && dist[edge[i][0]] == 50001) {
                    dist[edge[i][0]] = dist[edge[i][1]] + 1;
                    q.add(edge[i][0]);
                }
            }
        }

        int max = 0;
        int maxCnt = 0;
        for (int i=1; i<n+1; i++) {
            if (dist[i] > max) {
                max = dist[i];
                maxCnt = 0;
            }
            if (dist[i] == max) {
                maxCnt++;
            }
        }
        answer = maxCnt;
        return answer;
    }


}