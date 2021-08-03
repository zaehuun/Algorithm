import java.util.*;
class Solution {
    static class Pos{
        int r;
        int c;
        int cnt;
        Pos(int r,int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int bfs(int r, int c, int[][] maps, int rowLen, int colLen){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(r,c,1));
        maps[r][c] = 1;
        while(queue.size() != 0){
            Pos pos = queue.poll();
            if (pos.r == rowLen - 1 && pos.c == colLen - 1) return pos.cnt;
            for(int i = 0; i < 4; i++){
                int tx = pos.r + dx[i];
                int ty = pos.c + dy[i];
                if (tx < 0 || tx >= rowLen || ty < 0 || ty >= colLen) continue;
                if (maps[tx][ty] == 0 || maps[tx][ty] > 1) continue;
                maps[tx][ty] = pos.cnt+1;
                queue.offer(new Pos(tx,ty,pos.cnt+1)); 
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        int rowLen = maps.length;
        int colLen = maps[0].length;
        int answer = bfs(0,0,maps,rowLen,colLen);
        return answer;
    }
}
