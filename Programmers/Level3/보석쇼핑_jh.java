import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        //R D E S
        int[] answer = new int[2];
        Set<String> gem = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String g : gems) gem.add(g);
        
        int totalCnt = gem.size();
        
        int left = 0;
        int right = 0;
        int d = 100000;
        while(true){
            // if(right == gems.length) break;
            if(gem.size() == map.keySet().size()){ //모든 보석을 포함
                if(right - left < d){
                    d = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                    
                map.put(gems[left], map.get(gems[left]) - 1);
                // List<String> li = new ArrayList<>();
                // for(String key : map.keySet()){
                //     if(map.get(key) == 0) li.add(key);
                // }
                // for(String key : li)
                //     map.remove(key);
                if(map.get(gems[left]) == 0)
                    map.remove(gems[left]);
                left += 1;
            }
            else if(right == gems.length) break;
            else{ //아직 모든 보석 포함 x
                if(!map.containsKey(gems[right])) map.put(gems[right], 0);
                map.put(gems[right], map.get(gems[right]) + 1);
                right += 1;
            }
        }
        answer[0] += 1;
        return answer;
    }
}
