import java.util.*;

class Solution {

    public int bfs(char[][] arr, int y, int x, char type, boolean[][] visit){
        
        if(y + 1 >= arr.length || x + 1 >= arr[0].length) return 0;

        char right = arr[y][x+1];
        char down = arr[y+1][x];
        char cross = arr[y+1][x+1];

        if(type == right && type == down && type == cross){
            visit[y][x] = true;
            visit[y][x+1] = true;
            visit[y+1][x] = true;
            visit[y+1][x+1] = true;
            return 1;
        }
        return 0;
    }
    public int solution(int m, int n, String[] board) {
        
        int answer = 0;
        
        char[][] arr = new char[board.length][board[0].length()];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            boolean[][] visit = new boolean[arr.length][arr[0].length];
            
            int flag = 0;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[0].length; j++){
                    if(arr[i][j] == '0') continue;
                    flag += bfs(arr,i,j,arr[i][j], visit);
                }
            }
            
            if(flag == 0) break;
            
            for(int i = 0; i < arr[0].length; i++){
                List<Character> list = new ArrayList<>();
                for(int j = arr.length - 1; j >= 0; j--){
                    if(visit[j][i]){
                        answer++;
                    }
                    else{
                        list.add(arr[j][i]);
                    }
                }
                int idx = 0;
                for(int j = arr.length - 1; j >= 0; j--){
                    if(idx < list.size()){
                        arr[j][i] = list.get(idx);    
                    }
                    else{
                        arr[j][i] = '0';
                    }
                    idx++;
                }
            }
        }
        
        return answer;
    }
}
