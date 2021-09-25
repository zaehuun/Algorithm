//해설 코드를 보니 나랑 같은 생각인 사람이 딱 한 명 있었다.
//나머지 사람들은 PQ를 사용해서 풀던데 그 방법이 훨씬 더 깔끔해보이긴 했다..
//광고 삽입 문제를 풀면서 시간을 인덱스 개념으로 나누는 법을 알게 돼서 이 문제에도 유용하게 써먹은 거 같다.
import java.util.*;
class Solution {
    public String intToTime(int time){
        String mm = Integer.toString(time % 60);
        String hh = Integer.toString(time / 60);
        
        mm = mm.length() == 1 ? "0"+mm : mm;
        hh = hh.length() == 1 ? "0"+hh : hh;
        return hh+":"+mm;
    }
    public String solution(int n, int t, int m, String[] timetable) {
        LinkedHashMap<Integer, List<Integer>> times = new LinkedHashMap<>();
        
        int[] timesKey = new int[n];
        for(int i = 0; i < n; i++){
            times.put(540 + i * t, new ArrayList<Integer>());
            timesKey[i] = 540 + i * t;
        }
        
        List<Integer> timeList = new ArrayList<>();
        for(String time : timetable){
            String[] hm = time.split(":");
            int mm = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            timeList.add(mm);
        }
        Collections.sort(timeList);
        
        int timesKeyIdx = 0;
        int timeListIdx = 0;
        while(timesKeyIdx < n){
            while(timeListIdx < timetable.length){
                if(times.get(timesKey[timesKeyIdx]).size() >= m) break;
                if(timeList.get(timeListIdx) > timesKey[timesKeyIdx]) break;
                times.get(timesKey[timesKeyIdx]).add(timeList.get(timeListIdx));
                timeListIdx++;
            }
            timesKeyIdx++;  
        }
        if(times.get(timesKey[timesKey.length-1]).size() < m){
            return intToTime(timesKey[timesKey.length-1]);
        }
        else{
            int min = Collections.max(times.get(timesKey[timesKey.length-1])) - 1;
            return intToTime(min);
        }
    }
}
