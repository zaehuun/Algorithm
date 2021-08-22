import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            Stack<Character> st = new Stack<>();
            for (int j=0; j<s.length(); j++) {
                if (st.size() > 0 &&
                        ((st.peek() == '[' && sb.charAt(j) == ']') ||
                         (st.peek() == '(' && sb.charAt(j) == ')') ||
                         (st.peek() == '{' && sb.charAt(j) == '}'))) {
                        st.pop();
                }
                else {
                    st.push(sb.charAt(j));
                }
            }
            if (st.size() == 0) {
                answer++;
            }
            String firstLetter = sb.substring(0, 1);
            sb.deleteCharAt(0);
            sb.append(firstLetter);
        }

        return answer;
    }
}