import java.util.*;
/*
20분 - Cheating : X
*/
class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        s = (s.substring(2, s.length()-2)).replace("},{", "/"); // 앞뒤로 괄호 제거 후 /로 구분
        String[] splited = s.split("/");
        Arrays.sort(splited, Comparator.comparing(String::length));
        ArrayList<Integer> ansTmp = new ArrayList<>();
        for (int i=0; i<splited.length; i++) {
            String[] splited2 = splited[i].split(",");

            for (int j=0; j<splited2.length; j++) {
                int n = Integer.parseInt(splited2[j]);
                if (!ansTmp.contains(n)) {
                    ansTmp.add(n);
                }
            }
        }
        answer = new int[ansTmp.size()];
        for (int i=0; i<ansTmp.size(); i++) {
            answer[i] = ansTmp.get(i);
        }
        return answer;
    }
}