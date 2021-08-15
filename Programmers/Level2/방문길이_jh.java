import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int answer = 0;
        int y = 0;
        int x = 0;
        for(char c : dirs.toCharArray()){
            int ty = y;
            int tx = x;
            if(c == 'L'){ tx = tx - 1;}
            if(c == 'R'){ tx = tx + 1;}
            if(c == 'U'){ ty = ty - 1;}
            if(c == 'D'){ ty = ty + 1;}
            if(ty >= -5 && ty <= 5 && tx >= -5 && tx <= 5){
                String v = Integer.toString(ty)+Integer.toString(tx)+Integer.toString(y)+Integer.toString(x);
                String rv = Integer.toString(y)+Integer.toString(x)+Integer.toString(ty)+Integer.toString(tx);
                // if(y!= 0 && x != 0)
                if(!set.contains(v) && !set.contains(rv))
                    set.add(v);
                y = ty;
                x = tx;
            }
        }
        return set.size();
    }
}
