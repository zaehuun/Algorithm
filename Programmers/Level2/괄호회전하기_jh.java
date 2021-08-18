import java.util.*;
class Solution {
    public boolean check(Queue<Character> que){
        Stack<Character> st = new Stack<>();
        for(char c : que){
            if(st.isEmpty()) st.push(c);
            else{
                char top = st.peek();
                if (top == '(' && c == ')') st.pop();
                else if (top == '[' && c == ']') st.pop();
                else if (top == '{' && c == '}') st.pop();
                else st.push(c);
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
    public int solution(String s) {
        Queue<Character> que = new LinkedList<>();
        for(char c : s.toCharArray())
            que.offer(c);
        int answer = 0;
        
        int n = que.size();
        int idx = 0;
    
        while(idx < n){
            if(check(que)) answer++;
            que.offer(que.poll());
            idx++;
        }
        
        return answer;
    }
}
