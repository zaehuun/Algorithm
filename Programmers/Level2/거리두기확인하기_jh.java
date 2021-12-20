class Solution {
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,1,-1};
    int[] ddy = {2,-2,0,0};
    int[] ddx = {0,0,2,-2};
    int[] cy = {-1,-1,1,1};
    int[] cx = {-1,1,-1,1};
    public boolean check(int row, int col, String[] place){
        //거리 1이 사람인 경우
        for(int i = 0; i < 4; i++){
            int ty = row + dy[i];
            int tx = col + dx[i];
            if(ty < 0 || tx < 0 || ty >= place.length || tx >= place[0].length()) continue;
            if(place[ty].charAt(tx) == 'P') return false;
        }
        for(int i = 0; i < 4; i++){
            int ty = row + ddy[i];
            int tx = col + ddx[i];
            if(ty < 0 || tx < 0 || ty >= place.length || tx >= place[0].length()) continue;
            if(place[ty].charAt(tx) == 'P' && place[(ty+row) / 2].charAt((tx+col) / 2) == 'O') return false;
        }
        
        for(int i = 0; i < 4; i++){
            int ty = row + cy[i];
            int tx = col + cx[i];
            if(ty < 0 || tx < 0 || ty >= place.length || tx >= place[0].length()) continue;
            if(place[ty].charAt(tx) == 'P' && (place[ty].charAt(col) == 'O' || place[row].charAt(tx) == 'O')) return false;
        }
        
        return true;
    }
    public boolean checkPlace(String[] places){
        for(int row = 0; row < places.length; row++){
            for(int col = 0; col < places[0].length(); col++){
                if(places[row].charAt(col) == 'P'){
                    if(!check(row,col,places)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            if(checkPlace(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
}
