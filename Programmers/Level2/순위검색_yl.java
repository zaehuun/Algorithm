import java.util.*;
/*
3시간 - Cheating : O
Collections.sort를 바보같이 query for문 안에서 해서 계속 시초가 났었다....
이분탐색을 연습했다!
*/
class Solution {
    public int[] solution(String[] info, String[] query) {
        for (int i=0; i<info.length; i++) {
            String[] split = info[i].split(" ");
            int score = Integer.parseInt(split[4]);
            String s = info[i].substring(0, info[i].length()-split[4].length()-1);
            combination ("", 0, split, score);
        }

        for (String s : hm.keySet()) {
            Collections.sort(hm.get(s));
        }

        int[] answer = new int[query.length];
        for (int i=0; i<query.length; i++) {
            String s = query[i].replaceAll("and ", "");
            String[] split = s.split(" ");
            int score = Integer.parseInt(split[4]);
            s = s.substring(0, s.length() - split[4].length());
            s = s.replaceAll(" ", "");

            int cnt = 0;
            ArrayList<Integer> tmp = hm.get(s);
            if (!hm.containsKey(s)) {
                answer[i] = 0;
                continue;
            }
            int start = 0;
            int end = tmp.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (tmp.get(mid) < score) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            answer[i] = tmp.size() - start;
        }
        return answer;
    }
    static HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
    private static void combination (String s, int depth, String[] info, int score) {
        if (depth == 4) {
            if (hm.containsKey(s)) {
                hm.get(s).add(score);
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(score);
                hm.put(s, tmp);
            }
            return;
        }
        combination (s+info[depth], depth+1, info, score);
        combination (s+"-", depth+1, info, score);
    }
}