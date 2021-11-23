import java.util.*;
class Solution {
    public class node{
        int y;
        int x;
        int dir;
        int cnt;
        
        public node(int y, int x, int dir, int cnt){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    //0동 1남 2서 3부
    boolean[][][] arr;
    public int bfs(int y, int x, int dir, String[] grid){
        int row = grid.length;
        int col = grid[0].length();
        Queue<node> que = new LinkedList<>();
        que.offer(new node(y,x,dir,1));
        
        while(que.size() > 0){
            node n = que.poll();
            int ty = n.y;
            int tx = n.x;
            arr[ty][tx][n.dir] = true;
            if(n.dir == 0) tx++;
            else if(n.dir == 1) ty++;
            else if(n.dir == 2) tx--;
            else if(n.dir == 3) ty--;
            
            if(ty>=row) ty = 0;
            else if(ty<0) ty = row - 1;
            
            if(tx>=col) tx = 0;
            else if(tx<0) tx = col -1;
            char target = grid[ty].charAt(tx);
            int targetDir = n.dir;
            if(target == 'S'){
                targetDir = n.dir;
            }
            else if(target == 'L'){
                targetDir--;
                if(targetDir == -1) targetDir = 3;
            }
            else if(target == 'R'){
                targetDir++;
                if(targetDir == 4) targetDir = 0;
            }
            if(arr[ty][tx][targetDir]) return n.cnt;
            que.offer(new node(ty,tx,targetDir,n.cnt+1));
        }
        return 0;
    }
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();;
        arr = new boolean[grid.length][grid[0].length()][4];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                for(int k = 0; k < 4; k++){
                    if(arr[i][j][k] == true) continue;
                    answer.add(bfs(i,j,k,grid));
                }
            }
        }
        Collections.sort(answer);
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++)
            result[i] = answer.get(i);
        return result;
    }
}
