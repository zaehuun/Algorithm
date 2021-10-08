import java.util.*;
/*
1시간 - Cheating : X
*/
class Solution {
    static class Boxer implements Comparable<Boxer> {
        int idx;
        int weight;
        double average;
        int winHeavier;

        Boxer (int idx, int weight, double average, int winHeavier) {
            this.idx = idx;
            this.weight = weight;
            this.average = average;
            this.winHeavier = winHeavier;
        }

        public int compareTo (Boxer b) {
            if (b.average < this.average) {
                return -1;
            }
            else if (b.average > this.average) {
                return 1;
            }
            else {
                if (b.winHeavier == this.winHeavier) {
                    if (b.weight == this.weight) {
                        return this.idx - b.idx;
                    }
                    return b.weight - this.weight;
                }
                return b.winHeavier - this.winHeavier;
            }
        }
    }
    public int[] solution(int[] weights, String[] head2head) {
        int n = weights.length;
        int[] answer = new int[n];

        int map[][] = new int[n][n];
        int heavier[] = new int[n];
        double average[] = new double[n];
        for (int i=0; i<n; i++) {
            int cnt = 0; // 자기보다 무거운애 이긴 횟수
            int winCnt = 0;
            int gameCnt = 0; // 총 게임 횟수
            for (int j=0; j<n; j++) {
                if (head2head[i].charAt(j) == 'W') {
                    map[i][j] = 1;
                    map[j][i] = -1;
                    if (weights[i] < weights[j]) {
                        cnt++;
                    }
                    winCnt++;
                    gameCnt++;
                }
                else if (head2head[i].charAt(j) == 'L') {
                    map[i][j] = -1;
                    map[j][i] = 1;
                    gameCnt++;
                }
            }
            heavier[i] = cnt;
            average[i] = (double)winCnt / (double)(gameCnt);
        }
        ArrayList<Boxer> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            al.add(new Boxer(i+1, weights[i], average[i], heavier[i]));
        }
        Collections.sort(al);

        for (int i=0; i<n; i++) {
            Boxer b = al.get(i);
            answer[i] = b.idx;
        }
        return answer;
    }
}