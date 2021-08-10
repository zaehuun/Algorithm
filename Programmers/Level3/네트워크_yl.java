/*
10분 - Cheating : X
*/
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[][] visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (computers[i][j] == 1  && !visited[i][j]) {
                    answer++;
                    dfs(i, j, computers, visited);
                }
            }
        }

        return answer;
    }
    private static void dfs (int y, int x, int[][] computers, boolean[][] visited) {
        for (int i=0; i<computers.length; i++) {
            if (computers[x][i] == 1 && !visited[x][i]) {
                visited[x][i] = true;
                dfs (x, i, computers, visited);
            }
        }
    }
}