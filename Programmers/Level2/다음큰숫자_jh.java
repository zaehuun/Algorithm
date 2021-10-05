class Solution {

    public int countOne(String s){
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '1') cnt++;
        }
        return cnt;
    }
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int cnt = countOne(s);
        if(cnt == 1) return n << 1;
        n = n + 1;
        while(true){
            String num = Integer.toBinaryString(n);
            int numCnt = countOne(num);
            if(cnt == numCnt) break;
            n = n + 1;
        }
        return n;
    }
}
