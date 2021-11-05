import java.util.*;
class Solution {
    public boolean[] visit;
    public List<Set<Integer>> answer = new ArrayList<>();
    public void dfs(int idx, int cnt, int length, String[][] relation){
        if(cnt == length){
            Set<Integer> list = new HashSet<>();
            for(int i = 0; i < relation[0].length; i++){
                if(visit[i]) list.add(i);
            }
            
            for(Set<Integer> s : answer){
                if(list.containsAll(s)) return;
            }
            Set<String> set = new HashSet<>();
            for(int i = 0; i < relation.length; i++){
                String tmp = "";
                for(int j : list)
                    tmp += relation[i][j];                
                if(set.contains(tmp)) return;
                set.add(tmp);
            }
            answer.add(list);
            return;
        }
        for(int i = idx; i < relation[0].length; i++){
            visit[i] = true;
            dfs(i+1,cnt+1,length,relation);
            visit[i] = false;
        }
    }
    public int solution(String[][] relation) {
        visit = new boolean[relation[0].length];
        for(int i = 1; i <= relation[0].length; i++)
            dfs(0,0,i, relation);
        return answer.size();
    }
}
