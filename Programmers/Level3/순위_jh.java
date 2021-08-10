class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < results.length; i++){
            int win = results[i][0];
            int lose = results[i][1];
            arr[win-1][lose-1] = 1;
            arr[lose-1][win-1] = -1;
        }
        
        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++){
                    if(arr[i][k] == 0) continue;
                    if(arr[i][k] == arr[k][j]){
                        arr[i][j] = arr[i][k];
                        arr[j][i] = arr[i][j] * (-1);
                    }
                }
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0) cnt++;
            }
            if(cnt == 1) answer++;
        }
        return answer;
    }
}
