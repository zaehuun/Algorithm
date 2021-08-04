import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(j == 0) land[i][j] += Math.max(land[i-1][j+1], Math.max(land[i-1][j+2],land[i-1][j+3]));
                else if (j == land[0].length-1)land[i][j] += Math.max(land[i-1][j-1], Math.max(land[i-1][j-2],land[i-1][j-3]));
                else {
                    if(j==1){
                        land[i][j] += Math.max(land[i-1][j-1], Math.max(land[i-1][j+1],land[i-1][j+2]));
                    }
                    else{
                        land[i][j] += Math.max(land[i-1][j-2], Math.max(land[i-1][j-1],land[i-1][j+1]));    
                    }
                }
            }
        }
        
        return Arrays.stream(land[land.length-1])
                .max()
                .getAsInt();
    }
}
