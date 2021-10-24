import java.util.*;
class Solution {

    public int answer = 9999;
    public int nowNode = 0;
    public Set<Integer> visit;
    public void dfs(int idx, boolean[][] arr, int n){
        nowNode++;
        visit.add(idx);
        for(int i = 1; i <= n; i++){
            // System.out.println(arr.length + " " + i);
            if(arr[idx][i] == false) continue;
            if(visit.contains(i)) continue;
            dfs(i,arr, n);
        }
    }
    public int solution(int n, int[][] wires) {
        boolean[][] arr = new boolean[n+1][n+1];
        for(int[] wire : wires){
            int st = wire[0];
            int end = wire[1];
            arr[st][end] = arr[end][st] = true;
        }
        
        for(int[] wire : wires){
            int st = wire[0];
            int end = wire[1];
            arr[st][end] = arr[end][st] = false;
            
            visit = new HashSet<>();
            nowNode = 0;
            dfs(1,arr, n);
            answer = Math.min(answer,Math.abs(n-nowNode-nowNode));
            arr[st][end] = arr[end][st] = true; 
        }
        
        return answer;
    }
}
