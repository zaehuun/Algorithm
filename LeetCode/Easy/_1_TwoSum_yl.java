/*
1시간 - Cheating : X
HashMap으로 푸는거 생각했는데 중복 어떻게할지 모르겠어서 Sort인가 에라 모르겠다 하고 2중 for문으로 제출했는데 아쉽다. put만 늦게해주면 되는거였다!
*/
public class _1_TwoSum_yl {
    // 내 코드
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 정답
    public int[] twoSumAnswer(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // val, idx
        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement)) {
                return new int[]{i, hm.get(complement)};
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}
