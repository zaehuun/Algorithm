//아직 문자열 관련 함수가 익숙하지 않다...

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder answer = new StringBuilder();
        answer.append(Character.toUpperCase(s.charAt(0)));
        // System.out.println(s[0]);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ') answer.append(s.charAt(i));
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') answer.append(s.charAt(i));
            else if(s.charAt(i-1) == ' ') answer.append(Character.toUpperCase(s.charAt(i)));
            else answer.append(s.charAt(i));
        }
        return answer.toString();
    }
}
