/*
30분 - Cheating : X
*/
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, 0, visited);
        return minCnt != Integer.MAX_VALUE? minCnt : 0;
    }
    static int minCnt = Integer.MAX_VALUE;
    private static void dfs (String previous, String target, String[] words, int depth, boolean[] visited) {
        if (previous.equals(target)) {
            minCnt = Math.min(minCnt, depth);
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (visited[i]) {
                continue;
            }
            int diffCnt = 0;
            for (int j=0; j<words[i].length(); j++) {
                if (words[i].charAt(j) != previous.charAt(j)) {
                    diffCnt++;
                }
            }
            if (diffCnt != 1) {
                continue;
            }
            visited[i] = true;
            dfs (words[i], target, words, depth+1, visited);
            visited[i] = false;
        }
    }
}