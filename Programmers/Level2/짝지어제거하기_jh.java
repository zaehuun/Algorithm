import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(st.empty()) st.push(s.charAt(i));
            else{
                if(st.peek() == s.charAt(i)) st.pop();
                else st.push(s.charAt(i));
            }
        }
        if(st.empty()) return 1;
        else return 0;
    }
}
