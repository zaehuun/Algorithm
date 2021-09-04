import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap();
    public void combinations(char[] arr, int idx, String st, int cnt){
        if(st.length() == cnt){
            if(!map.containsKey(st)) map.put(st,0);
            map.put(st, map.get(st) + 1);
        }
        else{
            for(int i = idx; i < arr.length; i++){
                String s = st + Character.toString(arr[i]);
                combinations(arr, i + 1, s, cnt);
            }
        }
    }
    public String[] solution(String[] orders, int[] course) {
        
        List<String> result = new ArrayList();
        
        for(int c : course){
            for(String st : orders){
                char[] sorted = st.toCharArray();
                Arrays.sort(sorted);
                combinations(sorted,0, "", c);
            }
            if(map.size() == 0) continue;
            Integer max = Collections.max(map.values());
            if(max < 2) continue;
            for(String key : map.keySet()){
                if(map.get(key) == max)
                    result.add(key);
            }
            map = new HashMap();
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}
