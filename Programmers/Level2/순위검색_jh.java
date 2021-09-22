import java.util.*;
class Solution {
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    public void dfs(String[] st, String key, int idx){
        if(idx == 4){
            if(!map.containsKey(key)) map.put(key, new ArrayList<Integer>());
            map.get(key).add(Integer.parseInt(st[4]));
        }
        else{
            dfs(st, key + st[idx], idx + 1);
            dfs(st, key + "-", idx + 1);
        }
    }
    public int[] solution(String[] info, String[] query) {
        //언어, 직군, 경력 음식, 점수
        int[] answer = new int[query.length];
        for(String s : info){
            String[] st = s.split(" ");
            dfs(st, "", 0);
        }
        for(String key : map.keySet()){
            // if(key.equals("----"))
            //     System.out.println(map.get(key));
            Collections.sort(map.get(key));
            System.out.println(key);
        }
        for(int s = 0; s < query.length; s++){
            String q = query[s];
            q = q.replace(" and ", " ");
            String[] qs = q.split(" ");
            int score = Integer.parseInt(qs[4]);
            String key = qs[0]+qs[1]+qs[2]+qs[3];
            if(!map.containsKey(key)){
                answer[s] = 0;
                continue;
            }
            ArrayList<Integer> list = map.get(key);
            int idx = Collections.binarySearch(list, score);
            if (idx >= 0) {
                for (int a = idx - 1; a >= 0; a--) {
                    if (list.get(idx) - list.get(a) > 0) break;
                    else idx = a;
                }
                answer[s] = list.size() - idx;
            } else answer[s] = list.size() + idx + 1;
        }
        return answer;
    }
}
