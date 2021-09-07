import java.util.*;
/*
2시간 40분 - Cheating : X
wideLock 크기를 잘 못 잡아서 시간 다 낭비했다... 후....
*/
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        // lock의 0 개수 세기
        int lockCnt = 0;
        for (int i=0; i<lock.length; i++) {
            for (int j=0; j<lock.length; j++) {
                if (lock[i][j] == 0) {
                    lockCnt++;
                }
            }
        }
        // 큰 Lock 만들기 (패딩 붙이기)
        int[][] wideLock = new int[lock.length+2*(key.length-1)][lock.length+2*(key.length-1)];
        for (int i=key.length-1; i<lock.length+2*(key.length-1)-key.length+1; i++) {
            for (int j=key.length-1; j<lock.length+2*(key.length-1)-key.length+1; j++) {
                wideLock[i][j] = lock[i-key.length+1][j-key.length+1];
            }
        }

        // key 회전
        for (int r=0; r<4; r++) {
            int[][] newKey = new int[key.length][key.length];
            for (int i=0; i<key.length; i++) {
                for (int j=0; j<key.length; j++) {
                    newKey[j][key.length-i-1] = key[i][j];
                }
            }

            // 위치 이동
            for (int i=0; i<wideLock.length-key.length+1; i++) {
                for (int j=0; j<wideLock.length-key.length+1; j++) {

                    int coincideCnt = 0;
                    boolean breakFlag = false;

                    for (int k=0; k<key.length; k++) {
                        for (int l=0; l<key.length; l++) {
                            int start = key.length-1;
                            int end = lock.length+2*(key.length-1)-key.length+1;

                            if (start <= i+k && i+k <end && start <= j+l && j+l <end) {
                                if ((newKey[k][l] == 1 && wideLock[i+k][j+l] == 0) ||
                                    (newKey[k][l] == 0 && wideLock[i+k][j+l] == 1)) {

                                    if (wideLock[i+k][j+l] == 0) {
                                        coincideCnt++;
                                    }
                                }
                                else if (newKey[k][l] == 1 && wideLock[i+k][j+1] == 1){
                                    breakFlag = true;
                                    break;
                                }
                            }
                        }
                        if (breakFlag) {
                            break;
                        }
                    }

                    if (coincideCnt == lockCnt) {
                        answer = true;
                        return answer;
                    }
                }
            }
            key = newKey;
        }
        return answer;
    }
}