import java.util.*;
class Solution {
    public int calcFee(int time, int defaultTime, int defaultFee, int overTime, int overFee){
        if(time <= defaultTime){
            return defaultFee;
        }
        return defaultFee  +  (int)Math.ceil((float)(time - defaultTime) / overTime) * overFee;
        
    }
    public int calc(String time, String find){
        int startHour = Integer.parseInt(find.substring(0,2));
        int startMin = Integer.parseInt(find.substring(3,5));
        
        int endHour = Integer.parseInt(time.substring(0,2));
        int endMin = Integer.parseInt(time.substring(3,5));
        
        int result = 0;
        if(startMin > endMin){
            result = ((endHour - 1) - startHour) * 60 + Math.abs(60 - startMin + endMin);
        }
        else{
            result = (endHour - startHour) * 60 + Math.abs(startMin - endMin);
        }
        return result;
        
    }
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> list = new HashMap<>();
        for(String record : records){
            String[] r = record.split(" ");
            String time = r[0];
            String number = r[1];
            String type = r[2];
            
            if(type.equals("IN")){
                map.put(number, time);
            }
            else{
                String findTime = map.get(number);
                map.remove(number);
                int resultFee = calc(time, findTime);
                list.put(number, list.getOrDefault(number,0) + resultFee);
            }
        }
        
        for(String number : map.keySet()){
            int resultFee = calc("23:59", map.get(number));
            list.put(number, list.getOrDefault(number,0) + resultFee);
        }
        
        List<String> f = new ArrayList<>();
        Map<String, Integer> newmap = new HashMap<String, Integer>();
        for(String number : list.keySet()){
            int result = calcFee(list.get(number), fees[0], fees[1], fees[2], fees[3]);
            newmap.put(number, result);
            f.add(number);
        }
        Collections.sort(f);
        int[] answer = new int[f.size()];
        for(int i = 0; i < f.size(); i++){
            answer[i] = newmap.get(f.get(i));
        }
        
        return answer;
    }
}
