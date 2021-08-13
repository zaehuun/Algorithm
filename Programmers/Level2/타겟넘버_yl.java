/*
20분 - Cheating : X
*/
class Solution {
  static int answer = 0;
  public int solution(int[] numbers, int target) {
      boolean[] visited = new boolean[numbers.length];
      dfs (0, visited, numbers, target);
      return answer;
  }
  private static void dfs (int n, boolean[] visited, int[] numbers, int target) {
      for (int i=n; i<visited.length; i++) {
          if (!visited[i]) {
              visited[i] = true;
              dfs (i, visited, numbers, target);
              visited[i] = false;
          }
      }

      int sum = 0;
      for (int i=0; i<visited.length; i++) {
          if (visited[i]) {
              sum += numbers[i];
          }
          else {
              sum -= numbers[i];
          }
      }
      if (sum == target) {
          answer++;
      }

  }
}