class Solution {
    public int result = 0;
    public void dfs(int[]numbers, int idx, int sum, int target){
        if(idx == numbers.length){
            if(sum == target){
                result++;
            }
            // System.out.println(sum);
            return;
        }
        dfs(numbers,idx+1, sum + numbers[idx], target);
        dfs(numbers,idx+1, sum - numbers[idx], target);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,1,numbers[0],target);
        dfs(numbers,1,-numbers[0],target);
        return result;
    }
}
