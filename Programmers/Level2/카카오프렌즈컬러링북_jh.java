
import java.util.*;
class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    boolean[][] visited = new boolean[101][101];
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public void bfs(int i, int j, int value,int m, int n, int[][] picture){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(i,j));
        visited[i][j] = true;
        int v = value;
        int cnt = 1;
        while(queue.size()!=0){
            List<Integer> list = queue.poll();
            int x = list.get(0);
            int y = list.get(1);
            for(int t = 0; t < 4; t++){
                int tx = x + dx[t];
                int ty = y + dy[t];

                if(tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                if(visited[tx][ty] || picture[tx][ty] != value) continue;

                visited[tx][ty] = true;
                cnt++;
                queue.offer(Arrays.asList(tx,ty));

            }
        }
        if(map.containsKey(value)){
            List<Integer> li = map.get(value);
            int a = li.get(0); //영역
            int b = li.get(1);
            map.put(value,Arrays.asList(a+1, Math.max(cnt,b)));
        }
        else
            map.put(value,Arrays.asList(1,cnt));
    }
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];


        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0) continue;
                if(!visited[i][j]) bfs(i,j,picture[i][j],m,n,picture);
            }
        answer[0] = 0;
        answer[1] = 0;
        for(int key : map.keySet()){
            answer[0] += map.get(key).get(0);
            answer[1] = Math.max(answer[1],map.get(key).get(1));
        }
        return answer;
    }
}

