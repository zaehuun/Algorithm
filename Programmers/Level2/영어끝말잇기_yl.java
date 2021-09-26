import java.util.*;
/*
20분 - Cheating : X
*/
class Solution {
    public int[] solution(int n, String[] words) {
        int breakIdx = -1;
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        for (int i=1; i<words.length; i++) {
            if (hs.contains(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                breakIdx = i;
                break;
            }
            else {
                hs.add(words[i]);
            }
        }
        int[] answer = new int[2];
        if (breakIdx != -1) {
            answer[0] = breakIdx % n + 1;
            answer[1] = breakIdx / n + 1;
        }
        return answer;
    }
}