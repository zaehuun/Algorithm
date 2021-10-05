import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int word = 65;
        int idx = 27;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= 26; i++,word++){
            String c = (char)word+"";
            map.put(c,i);
        }
        String prev = msg.charAt(0)+"";;
        for(int i = 1; i < msg.length(); i++){
            String now = prev + msg.charAt(i);
            if(map.containsKey(now)) prev = now;
            else{
                result.add(map.get(prev));
                map.put(now, idx++);
                prev = msg.charAt(i) + "";
            }
        }
        result.add(map.get(prev));
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        return answer;
    }
}
