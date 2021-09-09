//파이썬으로 코테를 풀 때 INF 값은 그냥 987654321로 했다. 치기 쉬워서..
//이번에도 987654321로 했는데 계속 음수가 나오길래 정말 아무 생각없이 구현 문제인줄알았다.
//근데 아무리 찾아도 음수가 나올 코드가 없어서 생각해보니 오버플로우가 발생하면 음수 값이 되는 것이 생각났다.
//자바 정수의 범위를 찾아보니 대충 최대 값은 200000000대였다.
//문제를 제대로 읽고 정확한 최대 값을 지정하는게 제일 좋겠다만 문제 읽기도 바쁜데 최대 값 생각까지는 하기 싫다..
//찾아보니 Integer.MAX_VALUE로 최대 값을 바로 얻을 수 있다고 한다. 대문자와 특수 문자의 조합은 너무 어지러우니
//그냥 200000000을 사용해야겠다.
//코테 볼 때 이런 문제는 어떻게 푸나하고 포기헀었는데 최근에 플로이드 와샬 알고리즘을 공부한 것이 좀 도움은 된 거 같다.
//이진 탐색, 위상 정렬, 투포인터, 다잌스트라 공부가 더 필요한 거 같다..
import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //n 노드 수
        //s 출발지점
        //a A도착지검
        //b B도착지점
        s = s - 1;
        a = a - 1;
        b = b - 1;
        int[][] arr = new int[n][n];
        for(int[] row : arr)
            Arrays.fill(row,200000000);
        for(int i = 0; i < n; i++)
            arr[i][i] = 0;
        
        for(int[] fr : fares){
            int c = fr[0]-1;
            int d = fr[1]-1;
            int f = fr[2];
            arr[c][d] = f;
            arr[d][c] = f;
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int answer = 200000000;
        for(int i = 0; i < n; i++)
            answer = Math.min(answer, arr[s][i] + arr[i][a] + arr[i][b]);
        
        return answer;
    }
}
