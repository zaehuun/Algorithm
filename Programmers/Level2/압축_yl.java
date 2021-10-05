import java.util.*;
/*
1시간 - Cheating : X
*/
class Solution {
    public int[] solution(String msg) {
        ArrayList<String> dict = new ArrayList<>();
        for (int i=0; i<26; i++) {
            dict.add(Character.toString('A'+i));
        }
        ArrayList<Integer> ans = new ArrayList<>();

        int startIdx = 0;

        while (true) {
            int dictIdx = -1;
            boolean containFlag = false;

            for (int i=msg.length()-1; i>=startIdx; i--) { // 제일 긴 것 찾기
                String str = msg.substring(startIdx, i+1);

                if (dict.contains(str)) {
                    containFlag = true;
                    ans.add(dict.indexOf(str) + 1);
                    dict.add(msg.substring(startIdx, Math.min(i+2, msg.length())));
                    startIdx = i;
                    break;
                }
            }
            if (!containFlag) {
                break;
            }
            startIdx++;
        }
        int[] answer = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}