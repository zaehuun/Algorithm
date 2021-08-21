import java.util.*;
/*
45분 - Cheating : X
StringBuilder로 풀다가 시초나서 오래걸렸다.
*/
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (st.size() == 0 || st.peek() != s.charAt(i)) {
                st.push(s.charAt(i));
            }
            else {
                st.pop();
            }
        }
        if (st.size() == 0) {
            answer = 1;
        }
        else {
            answer = 0;
        }
        return answer;
    }
}
