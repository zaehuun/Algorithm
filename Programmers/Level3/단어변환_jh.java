//아 시x 풀고나서 다른 사람들 풀이를 보니 하나만 다른 거 찾기 로직이 엄청 간단했다..
//길이가 같다는 조건을 알고 있는데도 그냥 순차 탐색 하면 안 될 거 같아서 시x

import java.util.*;
class Solution {
    public int answer = 200000000;
    public boolean flag = false;
    public boolean[] visit;
    public boolean diffOne(String begin, String target){
        char[] be = begin.toCharArray();
        char[] ta = target.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for(char c : be)
            map.put(c+"",map.getOrDefault(c+"",0)+1);
        int cnt = 0;
        for(char c : ta){
            if(!map.containsKey(c+"")) cnt++;
            else{
                map.put(c+"", map.get(c+"")-1);
                if(map.get(c+"") == 0) map.remove(c+"");
            }
        }
        if(map.size() != 1 || cnt != 1) return false;
        return true;
        
    }
    public void dfs(String begin, String target, int cnt, String[] words){
        if(begin.equals(target)){
            flag = true;
            answer = Math.min(answer,cnt);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visit[i] == false && diffOne(begin, words[i])){
                visit[i] = true;
                dfs(words[i], target, cnt + 1, words);
                visit[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin,target,0,words);
        return flag == true ? answer : 0;
    }
}
