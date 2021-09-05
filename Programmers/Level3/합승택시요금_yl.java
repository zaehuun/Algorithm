import java.util.*;
/*
2시간 - Cheating : O
다익스트라 ver => 시간초과
플로이드 와샬 써야함
*/
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(map[i], 1000000);
            map[i][i] = 0;
        }
        for (int i=0; i<fares.length; i++) { // 인접행렬 생성
            map[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
            map[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
        }
        for (int x=0; x<n; x++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][x] + map[x][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            answer = Math.min(answer, map[s-1][i] + map[i][a-1] + map[i][b-1]);
        }
        return answer;
    }
}