import java.util.*;
/*
1시간 - Cheating : X
전형적인 쉬운데 오래걸리는 카카오문제st
*/
class Solution {
    static int[] answer;
    static HashMap<String, Integer> hm = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i=0; i<enroll.length; i++) {
            hm.put(enroll[i], i);
        }
        answer = new int[enroll.length];
        for (int i=0; i<amount.length; i++) {
            int idx = -1;
            for (int j=0; j<enroll.length; j++) {
                if (enroll[j].equals(seller[i])) {
                    idx = j;
                    break;
                }
            }
            int earned = 100 * amount[i];
            answer[idx] += earned * 0.9;
            dfs ((int)(earned * 0.1), "", idx, enroll[idx], enroll, referral);
        }
        return answer;
    }
    private static void dfs (int money, String s, int idx, String prev, String[] enroll, String[] referral) {
        String str = referral[idx];
        if (str.equals("-") || money <= 0) {
            return;
        }
        int i = hm.get(str);
        int newMoneyVal = (int)(money * 0.1);
        answer[i] += money - newMoneyVal;
        dfs (newMoneyVal, s+" "+referral[idx], i, referral[idx], enroll, referral);
    }
}