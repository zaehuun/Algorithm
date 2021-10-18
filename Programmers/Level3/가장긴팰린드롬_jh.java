class Solution{
    public boolean check(String t, int start, int end){
        while(start < end){
            if(t.charAt(start) != t.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public int solution(String s){
        if(s.length() < 2) return 1;
        int answer = 0;
        for(int i = s.length(); i >= 0; i--){
            for(int j = 0; i + j <= s.length(); j++){
                if(check(s,j, i+j-1)) return i;
            }
        }
        return answer;
    }
}
