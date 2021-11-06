import java.util.*;
/*
1시간 - Cheating : O
대표적인 개같고 도움 안 되는 문제
*/
class Solution {
    public String[] solution(int[][] line) {
        HashSet<String> hs = new HashSet<>();
        int maxHeight = Integer.MIN_VALUE;
        int maxWidth = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        int minWidth = Integer.MAX_VALUE;
        for (int i=0; i<line.length; i++) {
            for (int j=i+1; j<line.length; j++) {
                long parent = (long)line[i][0] * (long)line[j][1] - (long)line[i][1] * (long)line[j][0];
                long child1 = (long)line[i][1] * (long)line[j][2] - (long)line[i][2] * (long)line[j][1];
                long child2 = (long)line[i][2] * (long)line[j][0] - (long)line[i][0] * (long)line[j][2];
                if (parent == 0 || child1 % parent != 0 || child2 % parent != 0) {
                    continue;
                }
                int x = (int)(child1/parent);
                int y = (int)(child2/parent);
                hs.add(y+" "+x);
                maxWidth = Math.max(maxWidth, x);
                maxHeight = Math.max(maxHeight, y);
                minWidth = Math.min(minWidth, x);
                minHeight = Math.min(minHeight, y);
            }
        }

        String[] answer = new String[Math.abs(maxHeight - minHeight)+1];
        int idx = 0;
        for (int i=maxHeight; i>=minHeight; i--) {
            String s = "";
            for (int j=minWidth; j<maxWidth+1; j++) {
                if (hs.contains(i+" "+j)) {
                    s += "*";
                }
                else {
                    s += ".";
                }
            }
            answer[idx++] = s;
        }
        return answer;
    }
}