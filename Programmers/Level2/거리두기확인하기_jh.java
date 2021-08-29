//경우의 수를 너무 복잡하게 생각하고 문제를 푸려고 한 거 같다...
//꼭 다시 풀어봐야 함.

class Solution {
    
    public boolean check(int y, int x, String[] arr){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i = 0; i < 4; i++){
            int ty = y + dy[i];
            int tx = x + dx[i];
            if(ty < 0 || ty >= 5 || tx < 0 || tx >= 5) continue;
            if(arr[ty].charAt(tx) == 'P') return true;
        }
        
        dx = new int[]{-2,2,0,0};
        dy = new int[]{0,0,-2,2};
        for(int i = 0; i < 4; i++){
            int ty = y + dy[i];
            int tx = x + dx[i];
            if(ty < 0 || ty >= 5 || tx < 0 || tx >= 5) continue;
            if(arr[ty].charAt(tx) == 'P' && arr[(ty+y)/2].charAt((tx+x)/2) != 'X') return true;
        }
        
        dx = new int[]{1,1,-1,-1};
        dy = new int[]{1,-1,1,-1}; // 4 2 8 10
        for(int i = 0; i < 4; i++){
            int ty = y + dy[i];
            int tx = x + dx[i];
            if(ty < 0 || ty >= 5 || tx < 0 || tx >= 5) continue;
            if(arr[ty].charAt(tx) == 'P' && !(arr[y].charAt(tx) == 'X' && arr[ty].charAt(x) == 'X')) return true;
        }
        
        return false;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        //p: 사람, 0: 빈 테이블, x: 파티션
        
        for(int i = 0; i < places.length; i++){
            boolean flag = false;
            for(int j = 0; j < places.length; j++){
                for(int k = 0; k < places.length; k++){
                    if(places[i][j].charAt(k) == 'P'){
                        if(check(j,k,places[i])){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag){
                    answer[i] = 0;
                    break;
                }
            }
            if(!flag){
                answer[i] = 1;
            }
            
        }
        return answer;
    }
}
