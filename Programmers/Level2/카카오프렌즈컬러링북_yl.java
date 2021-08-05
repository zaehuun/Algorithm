import java.util.*;
/*
30분 - Cheating : X
*/
class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    visited[i][j] = true;
                    cnt = 0;
                    dfs(i, j, picture, visited);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static int cnt = 0;
    private static void dfs (int y, int x, int[][] picture, boolean[][] visited) {
        cnt++;
        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= visited.length || nx < 0 || nx >= visited[0].length) {
                continue;
            }
            if (picture[ny][nx] != picture[y][x]) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            dfs (ny, nx, picture, visited);
        }
    }
}