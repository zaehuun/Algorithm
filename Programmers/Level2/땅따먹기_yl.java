class Solution {
  int solution(int[][] land) {
      int answer = 0;

      int[][] dp = new int[land.length][land[0].length];
      //dp[0] = land[0]; 이걸로 가능
      for (int i=0; i<4; i++) {
          dp[0][i] = land[0][i];
      }
      for (int i=1; i<dp.length; i++) {
          for (int j=0; j<4; j++) {
              int maxVal = 0;
              int maxIdx = -1;
              for (int k=0; k<4; k++) {
                  if (maxVal < dp[i-1][k] && j != k) {
                      maxVal = dp[i-1][k];
                      maxIdx = k;
                  }
              }
              dp[i][j] = dp[i-1][maxIdx] + land[i][j];
          }
      }
      answer = Math.max(Math.max(dp[dp.length-1][0], dp[dp.length-1][1]), Math.max(dp[dp.length-1][2], dp[dp.length-1][3]));
      return answer;
  }
}