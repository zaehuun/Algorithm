class Solution {
    public int countingStars(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '0') count++;
        }
        return count;
    }
    public String deleteZero(String s){
        String d = "";
        for(char c : s.toCharArray()){
            if(c == '0') continue;
            d += c;
        }
        return d;
    }
    
    public String binary(int num){
        String s = "";
        while(num > 0){
            s = s + (num % 2 == 0 ? 0 : 1);
            num = num >> 1;
        }
        return s;
    }
    public int[] solution(String s) {
        int[] answer = new int[2];
        int turn = 0;
        int zero = 0;
        while(!s.equals("1")){
            turn++;
            
            int zeroCount = countingStars(s);
            zero += zeroCount;
            int size = s.length() - zeroCount;
            s = binary(size);
            
        }
        answer[0] = turn;
        answer[1] = zero;
        return answer;
    }
}
