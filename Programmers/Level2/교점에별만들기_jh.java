import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        int n = line.length;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long gi = a * d - b * c;
                if(gi == 0) continue;
                
                long x = b * f - e * d;
                long y = e * c - a * f;
                if(x % gi != 0 || y % gi != 0) continue;
                int fx = (int)(x/gi);
                int fy = (int)(y/gi);
                set.add(fx + " " + fy);
                maxX = Math.max(maxX, fx);
                maxY = Math.max(maxY, fy);
                
                minX = Math.min(minX, fx);
                minY = Math.min(minY, fy);
            }
        }
        List<String> answer = new ArrayList<>();
        for(int i = maxY; i >= minY; i--){
            String st = "";
            for(int j = minX; j <= maxX; j++){
                if(set.contains(j + " " + i)) st+="*";
                else st+=".";
            }
            answer.add(st);
        }
        String[] result = new String[answer.size()];
        for(int i = 0; i < answer.size(); i++)
            result[i] = answer.get(i);
        return result;
    }
}
