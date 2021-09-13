import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        int turn = 1;
        int[] answer = {0,0};
        String first = words[0];
        char last = first.charAt(first.length()-1);
        
        Set<String> history = new HashSet<>();
        history.add(first);
        
        for(int i = 1; i < words.length; i++){
            if(history.contains(words[i]) || last != words[i].charAt(0)){
                answer[1] = i/n + 1;
                answer[0] = (turn + 1);
                break;   
            }
            turn = (turn + 1) % n;
            history.add(words[i]);
            last = words[i].charAt(words[i].length()-1);
        }
        return answer;
    }
}
