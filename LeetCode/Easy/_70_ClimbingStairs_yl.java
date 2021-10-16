/*
5분 - Cheating : X
DP 개기초 피보나치
*/
public class _70_ClimbingStairs_yl {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
