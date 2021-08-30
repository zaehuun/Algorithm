import java.util.*;
/*
30분 - Cheating : X
2가 소수가 아니라고 생각해서 시간 개씀 ㅁㅊ^^;;
*/
class Solution {
    public int solution(String numbers) {
        // numbers = "1234";
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        int[] nums = new int[numbers.length()];

        for (int i=0; i<numbers.length(); i++) {
            nums[i] = numbers.charAt(i)-'0';
        }
        permutation("", nums, visited);
        answer = ans.size();
        return answer;
    }
    static ArrayList<Integer> ans = new ArrayList<>();
    private static void permutation(String s, int[] nums, boolean[] visited) {
        if (!s.equals("")) {
            // System.out.println(s+" ->"+Integer.parseInt(s));
            int n = Integer.parseInt(s);
            if (isPrime(n)) {
                if (!ans.contains(n)) {
                    System.out.println(n);
                    ans.add(n);
                }
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(s+nums[i], nums, visited);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime (int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i*i <= n; ++i) {
            if(n % i == 0)  {
                return false;
            }
        }
        return true;
    }
}