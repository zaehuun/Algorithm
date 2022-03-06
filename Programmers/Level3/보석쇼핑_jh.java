import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
    
        Map<String, Integer> map = new HashMap<>();
        int lidx = 0;
        int ridx = 0;
        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        while(true){
            if(map.size() == set.size()){
                if(answer > ridx - lidx){
                    right = ridx;
                    left = lidx;
                    answer = ridx - lidx;
                }
                
                map.put(gems[lidx], map.get(gems[lidx]) - 1);
                if(map.get(gems[lidx]) == 0){
                    map.remove(gems[lidx]);
                }
                lidx++;
            }
            else if(ridx == gems.length) break;
            else{
                map.put(gems[ridx],map.getOrDefault(gems[ridx],0)+1);
                ridx++;
            }
        }
        
        int[] result = new int[2];
        result[0] = left + 1;
        result[1] = right;
        return result;
    }
}
