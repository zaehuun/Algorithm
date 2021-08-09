import java.util.*;
class Solution {
    boolean[] visited = new boolean[200];
    
    public void bfs(int n, int[][] computers, int idx){
        Queue<Integer> que = new LinkedList<>();
        visited[idx] = true;
        que.offer(idx);
        
        while (!que.isEmpty()){
            int dx = que.poll();
            for(int i = 0; i < n; i++){
                if(computers[dx][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                answer++;
                bfs(n,computers,i);
            }     
        }
        return answer;
    }
}
