import java.util.*;
class Solution {
    public boolean[] visit;
    public int answer = 0;
    public void dfs(int k, int n, ArrayList<Integer> list, int[][] d){
        if(list.size() == n){
            int cnt = 0;
            for(int idx : list){
                int minP = d[idx][0];
                int costP = d[idx][1];
                if(k < minP) break;
                k -= costP;
                cnt++;
                answer = Math.max(answer,cnt);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(visit[i]) continue;
            visit[i] = true;
            list.add(i);
            dfs(k,n,list,d);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length; //던전 수
        visit = new boolean[n];
        dfs(k,n, new ArrayList<Integer>(), dungeons);
        return answer;
    }
}
