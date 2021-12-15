//다시 풀기
import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] arr = new int[n][n];
        for(int[] row : arr){
            Arrays.fill(row, 200000000);
        }
        for(int[] fare : fares){
            int start = fare[0] - 1;
            int end = fare[1] - 1;
            int cost = fare[2];
            arr[start][end] = arr[end][start] = cost;
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        s = s - 1;
        a = a - 1;
        b = b - 1;
        int answer = arr[s][a] + arr[s][b];
        for(int i = 0; i < n; i++){
            int together = arr[s][i];
            if(a != i) together += arr[i][a];
            if(b != i) together += arr[i][b];

            answer = Math.min(answer, together);
        }
        return answer;
    }
}
