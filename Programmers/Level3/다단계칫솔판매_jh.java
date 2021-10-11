//졸려서 내일 다시 이어서 풀기
import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //개당 100원
        int[] answer = new int[enroll.length];
        Map<String, String> tree = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            String value = referral[i].equals("-") ? "root" : referral[i];
            tree.put(enroll[i], value);
        }
        
        for(int i = 0; i < seller.length; i++){
            String name = seller[i];
            int total = amount[i] * 100;
            
            
        }
        
        return answer;
    }
}
