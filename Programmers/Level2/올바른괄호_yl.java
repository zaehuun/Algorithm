import java.util.*;
/*
3분 - Cheating : X
*/
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            }
            else if (s.charAt(i) == ')') {
                if (st.size() > 0 && st.peek() == '(') {
                    st.pop();
                }
                else {
                    st.push(')');
                }
            }
        }
        if (st.isEmpty()) {
            answer = true;
        }
        else {
            answer = false;
        }
        return answer;
    }
}