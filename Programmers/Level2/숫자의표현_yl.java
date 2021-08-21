/*
15분 - Cheating : X
*/
class Solution {
  public int solution(int n) {
      int answer = 0;
      int startIdx = 1;
      int endIdx = 1;
      int[] arr = new int[n+2];
      for (int i=1; i<arr.length; i++) {
          arr[i] = i;
      }
      int sum = 0;
      while (true) {
          if (sum + arr[endIdx] < n) {
              sum += arr[endIdx];
              endIdx++;
          }
          else if (sum + arr[endIdx] > n) {
              sum -= arr[startIdx];
              startIdx++;
          }
          else if (sum + arr[endIdx] == n) {
              sum -= arr[startIdx];
              sum += arr[endIdx];
              answer++;
              startIdx++;
              endIdx++;
          }
          if (endIdx > n) {
              break;
          }
      }

      return answer;
  }
}