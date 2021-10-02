class Solution {
    int result;
    boolean find;
    public int dfs(String target, String now, String[] words){
        if(target.equals(now)){
            find = true;
            return result;
        }
        for(int i = 0; i < 5; i++){
            if(now.length() <5){
                if(find) return 0;
                result++;
                dfs(target, now + words[i], words);
            }
            
        }
        return 0;
    }
    public int solution(String word) {
        dfs(word, "", new String[]{"A","E","I","O","U"});
        return result;
    }
}
