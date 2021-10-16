/*
15분 - Cheating : O
경우의 수는 2개
1) 기존 값에 nums[i]를 포함하던가
2) 안 하고 nums[i]부터 새로 시작하던가
두 개 비교하면 됨
*/
public class _53_MaximumSubarray_yl {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
