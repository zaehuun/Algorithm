import java.util.*;
/*
1시간 - Cheating : O
테케 1번만 틀려서.. 최소 노드는 0개가 아니라 1개다... 이런걸 1시간이나 걸리다니... 빠가야로..
*/
class Solution {
    public int solution(int n, int[][] wires) {
        int[][] map = new int[n][n];

        for (int i=0; i<wires.length; i++) {
            map[wires[i][0]-1][wires[i][1]-1] = 1;
            map[wires[i][1]-1][wires[i][0]-1] = 1;
        }

        int answer = n;

        for (int i=0; i<wires.length; i++) {
            map[wires[i][0]-1][wires[i][1]-1] = 0;
            map[wires[i][1]-1][wires[i][0]-1] = 0;

            int[] cnt = {1, 1}; // 최소 노드 1개
            int idx = 0;
            boolean[][] visited = new boolean[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        visited[j][k] = true;
                        depth = 0;
                        cnt[idx++] = dfs (k, map, visited);
                    }
                }
            }
            answer = Math.min(answer, Math.abs(cnt[0] - cnt[1]));
            System.out.println(cnt[0]+" "+cnt[1]);
            map[wires[i][0]-1][wires[i][1]-1] = 1;
            map[wires[i][1]-1][wires[i][0]-1] = 1;
        }

        return answer;
    }

    static int depth = 0;
    private static int dfs (int y, int[][] map, boolean[][] visited) {
        depth++;
        for (int i=0; i<map.length; i++) {
            if (map[y][i] == 1 && !visited[y][i]) {
                visited[y][i] = true;
                visited[i][y] = true;
                dfs (i, map, visited);
            }
        }
        return depth;
    }
}