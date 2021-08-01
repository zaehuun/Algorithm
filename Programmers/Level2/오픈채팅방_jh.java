import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        for(String message : record){
            String[] list = message.split(" ");
            // System.out.println(list.toString());
            if(list[0].equals("Enter")){
                answer.add(Arrays.asList(list[1],"님이 들어왔습니다."));
                map.put(list[1],list[2]);
            }
            else if(list[0].equals("Leave"))
                answer.add(Arrays.asList(list[1],"님이 나갔습니다."));
            else if(list[0].equals("Change"))
                map.replace(list[1],list[2]);
        }
        String[] result = new String[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = map.get(answer.get(i).get(0))+answer.get(i).get(1);
        }
        return result;
    }
}
