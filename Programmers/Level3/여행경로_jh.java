//도착지들을 다 카운트로 기록하여 카운트가 0이 되면 해당 경로로는 더 이상 가지 못 하게 하려 했다.
//1번만 계속 틀리기에 프로그래머스 질문에 있는 모든 테케를 돌렸는데도 다 맞지만 계속 1번만 틀려서
//구글에서 겨우 틀린 테케를 하나 찾았다.
//	[["ICN", "BBB"], ["ICN", "CCC"], ["BBB", "CCC"], ["CCC", "BBB"], ["CCC", "ICN"]]
//["ICN", "BBB", "CCC", "ICN", "CCC", "BBB"]

//도착지를 카운트 해놓으면 BBB는 2가 된다.
//그러다보니 ICN BBB CCC까지가면 아직 BBB가 0이 아니기에 BBB를 다시 간다.
//그래서 정렬하고 값을 뽑으면 ICN BBB CCC BBB CCC ICN이 나온다.
//이렇게 공통된 카운트를 사용하는 건 좀 별로인 거 같아서 임의로 값만 변경하는 식으로 했다.
import java.util.*;
class Solution {
    List<String> result = new ArrayList<>();
    public void dfs(String start, Map<String, List<String>> map, String path, int size){
        if(path.split(" ").length == size+1)
            result.add(path);
        else{
            if(map.containsKey(start)){
                for(int i = 0; i < map.get(start).size(); i++){
                    if(map.get(start).get(i) != "x"){
                        String t = map.get(start).get(i);
                        map.get(start).set(i,"x");
                        dfs(t, map,path + " " + t,size);
                        map.get(start).set(i,t);    
                    }
                }
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Map<String, List<String>> map = new HashMap<>();
        
        for(String[] st : tickets){
            if(!map.containsKey(st[0])) map.put(st[0], new ArrayList<String>());
            map.get(st[0]).add(st[1]);
        }
        
        for(String st : map.keySet())
            Collections.sort(map.get(st));
        dfs("ICN",map,"ICN",tickets.length);
        Collections.sort(result);
        return result.get(0).split(" ");
    }
}
