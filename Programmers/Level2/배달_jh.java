class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] arr = new int[N][N];
        int distance[] = new int[N];
        boolean[] visit = new boolean[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                arr[i][j] = 200000000;
        } 
        
        for(int[] r : road){
            int st = r[0] - 1;
            int end = r[1] - 1;
            int v = r[2];
            if(arr[st][end] != 0 ) {
                arr[st][end] = v < arr[st][end] ? v : arr[st][end];
                arr[end][st] = v < arr[end][st] ? v : arr[end][st];
            }else {
                arr[st][end] = v;
                arr[end][st] = v;
            }

        }
        distance[0] =0;
        visit[0] =true;

        for(int i=1;i<N;i++){
            if(arr[0][i] !=0){
                distance[i] = arr[0][i];
            }
        }
        
        for(int a = 0; a < N-1; a++) {
            int min_distance = Integer.MAX_VALUE;
            int min_index = 0;
            for(int i = 0; i < N; i++) {
                if(!visit[i] && min_distance > distance[i]) {
                    min_distance = distance[i];
                    min_index = i;
                }
            }
            visit[min_index] = true;
            for(int i = 0; i < N; i++) {
                if(!visit[i] && arr[min_index][i] != 0) {
                    if(distance[i] > distance[min_index] + arr[min_index][i])
                        distance[i] = distance[min_index] + arr[min_index][i];
                }
            }
        }

        
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] <= K)
                answer++;
        }
 
        return answer;
    }
}
