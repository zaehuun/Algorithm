import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.empty()) st.push(c);
            else{
                char top = st.peek();
                if(top == '(' && c ==')') st.pop();
                else st.push(c);
            }
        }
        if(st.empty()) return true;
        return false;
    }
}
