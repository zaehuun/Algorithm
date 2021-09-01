public class ㅇ {

}
import java.util.*;
/*
1시간 - Cheating : X
노가다 문제
*/
class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 코스요리는 2가지 이상의 단품메뉴, 최소 2명 이상의 손님이 주문

        // orders[i]로 2 ~ len 만큼 조합 만들기
        for (int i=0; i<orders.length; i++) {
            String str = orders[i];
            for (int j=2; j<=str.length(); j++) {
                boolean[] visited = new boolean[str.length()];
                combination ("", -1, 0, visited, 0, str, j);
            }
        }

        ArrayList<String> ans = new ArrayList<>();

        HashMap<Integer, String> max = new HashMap<>();
        for (int i=0; i<course.length; i++) { // 2 3 4
            ArrayList<String> tmpAns = new ArrayList<>();
            int maxCnt = 2;
            String maxStr = "";
            for (String key : hm.keySet()) {
                if (key.length() == course[i]) { // Key 길이가 2, 3, 4고
                    if (hm.get(key) > maxCnt) { // max 보다 크면
                        tmpAns.clear();
                        tmpAns.add(key);
                        maxCnt = hm.get(key);
                    }
                    else if (hm.get(key) == maxCnt) {
                        tmpAns.add(key);
                    }
                }
            }
            ans.addAll(tmpAns);
        }
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    static HashMap<String, Integer> hm = new HashMap<>();
    private static void combination (String s, int bef, int start, boolean[] visited, int depth, String str, int len) {
        if (s.length() == len) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            }
            else {
                hm.put(s, 1);
            }
        }
        for (int i=start; i<visited.length; i++) {
            if (bef != i) {
                visited[i] = true;
                combination (s+=str.charAt(i), i, i+1, visited, depth+1, str, len);
                visited[i] = false;
                s = s.substring(0, s.length()-1);
            }
        }
    }
}