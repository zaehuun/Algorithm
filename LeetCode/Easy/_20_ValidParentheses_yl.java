/*
10분 - Cheating : X
프로그래머스에도 있는 유명한 괄호 문제.. 이미 아는거라 영양가는 없다. 정답이랑 풀이 거의 비슷하다.
*/
public class _2_ValidParentheses_yl {
    // 내 코드
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else {
                if (!st.isEmpty()) {
                    if ((s.charAt(i) == ')' && st.peek() == '(') ||
                        (s.charAt(i) == '}' && st.peek() == '{') ||
                        (s.charAt(i) == ']' && st.peek() == '[')) {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    // 정답
    public boolean isValidAnswer(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
