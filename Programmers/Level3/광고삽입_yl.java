import java.util.*;
/*
1시간 - Cheating : O
문제 보고 어케 풀지 전혀 모르겠어서 구글링해서 초로 변환하는거 알아내고 코드는 직접 짬
완전탐색 쉬운 문제...
17번만 틀렸었는데 sum이랑 max를 long으로 바꿔주면 된다.... 역시 카카오 의도가 상당히 불순해..
*/
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTimeSec = convertToSeconds(play_time);
        int[] secs = new int[playTimeSec+1];
        int advTimeSec = convertToSeconds(adv_time);
        for (int i=0; i<logs.length; i++) {
            String[] splited = logs[i].split("-");
            int start = convertToSeconds(splited[0]);
            int end = convertToSeconds(splited[1]);

            for (int j=start; j<end; j++) {
                secs[j]++;
            }
        }

        long sum = 0;
        for (int i=0; i<advTimeSec; i++) {
            sum += secs[i];
        }
        long max = sum;
        int maxIdx = 0;
        int startIdx = 0;
        for (int i=advTimeSec; i<secs.length; i++) {
            if (max < sum) {
                max = sum;
                maxIdx = startIdx;
            }
            sum += secs[i];
            sum -= secs[startIdx];
            startIdx++;
        }
        answer = secondsToHHMMSS(maxIdx);
        return answer;
    }
    private static int convertToSeconds (String s) {
        String[] splited = s.split(":");
        int result = 0;
        result += Integer.parseInt(splited[2]);
        result += Integer.parseInt(splited[1])*60;
        result += Integer.parseInt(splited[0])*60*60;
        return result;
    }
    private static String secondsToHHMMSS (int sec) {
        return String.format("%02d:%02d:%02d", sec / 3600, (sec % 3600) / 60, (sec % 60));
    }
}