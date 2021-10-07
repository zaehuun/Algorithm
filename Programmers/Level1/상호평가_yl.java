import java.util.*;
/*
38분 - Cheating : X
*/
class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        for (int i=0; i<scores[0].length; i++) {
            int max = -1;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j=0; j<scores.length; j++) {
                if (hm.containsKey(scores[j][i])) {
                    hm.put(scores[j][i], hm.get(scores[j][i])+1);
                }
                else {
                    hm.put(scores[j][i], 1);
                }

                sum += scores[j][i];

                if (scores[j][i] > max) {
                    max = scores[j][i];
                }
                if (scores[j][i] < min) {
                    min = scores[j][i];
                }
            }

            // 자기 자신을 평가한게 최저 or 최고 & 유일하다면
            int divide = scores.length;
            if (scores[i][i] == max && hm.get(scores[i][i]) == 1) {
                sum -= max;
                divide--;
            }
            else if (scores[i][i] == min && hm.get(scores[i][i]) == 1) {
                sum -= min;
                divide--;
            }
            sum /= divide;

            if (sum >= 90) {
                answer += "A";
            }
            else if (sum >= 80 && sum < 90) {
                answer += "B";
            }
            else if (sum >= 70 && sum < 80) {
                answer += "C";
            }
            else if (sum >= 50 && sum < 70) {
                answer += "D";
            }
            else if (sum < 50) {
                answer += "F";
            }
        }
        return answer;
    }
}