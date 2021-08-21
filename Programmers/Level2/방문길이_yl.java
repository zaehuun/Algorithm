import java.util.*;
/*
1시간 - Cheating : O
방향을 생각 못 했다. 이거 4차원 배열로 푸는사람 있는데 별로인듯..
*/
class Solution {
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int solution(String dirs) {
        int answer = 0;
        Pos p = new Pos (5, 5);
        ArrayList<String> al = new ArrayList<>();

        for (int i=0; i<dirs.length(); i++) {
            int y = 0;
            int x = 0;
            if (dirs.charAt(i) == 'L') {
                y = 0;
                x = -1;
            }
            else if (dirs.charAt(i) == 'R') {
                y = 0;
                x = 1;
            }
            else if (dirs.charAt(i) == 'U') {
                y = -1;
                x = 0;
            }
            else if (dirs.charAt(i) == 'D') {
                y = 1;
                x = 0;
            }
            if (p.y + y >= 0 && p.x + x >= 0 && p.y + y < 11 && p.x + x < 11) {
                String s1 = p.y+" "+p.x+" "+(p.y + y)+" "+(p.x + x); // 출발 / 도착
                String s2 = (p.y + y)+" "+(p.x + x)+" "+p.y+" "+p.x; // 도착 / 출발

                if (!al.contains(s1) && !al.contains(s2)) {
                    al.add(s1);
                    answer++;
                }
                p = new Pos (p.y + y, p.x + x);
            }
        }
        return answer;
    }
}