/*
20분 - Cheating : X
*/
class Solution {
  public int solution(int n, int[][] results) {
      int answer = 0;

      int[][] arr = new int[n][n];
      // 승리 1 패배 -1
      for (int i=0; i<results.length; i++) {
          arr[results[i][0]-1][results[i][1]-1] = 1;
          arr[results[i][1]-1][results[i][0]-1] = -1;
      }

      for (int k=0; k<n; k++) {
          for (int i=0; i<n; i++) {
              for (int j=0; j<n; j++) {
                  if (arr[i][k] == arr[k][j] && arr[k][j] != 0) {
                      arr[i][j] = arr[k][j];
                  }
              }
          }
      }

      for (int i=0; i<n; i++) {
          boolean isCountable = true;
          for (int j=0; j<n; j++) {
              if (arr[i][j] == 0 && i != j) {
                  isCountable = false;
                  break;
              }
          }
          if (isCountable) {
              answer++;
          }
      }

      return answer;
  }
}