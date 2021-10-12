//테케 3개가 시간 초류가 뜨길래 뭔지 알아보니 넘길 돈이 없는데도 계속 while문을 돌아서 시간 초과가 뜨는거였다..
// 1/10만 넘기다보니 5~6번만 탐색하면 된다고 한다. 루트까지 while문을 돌 필요가 없다고 한다.
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
            money.put(enroll[i],0);
        }
        for(int i = 0; i < seller.length; i++){
            String name = seller[i];
            int total = amount[i] * 100;
            int has = total - total / 10;
            money.put(name, money.get(name) + has);
            int pass = total - has;
            String boss = tree.get(name);
            total = pass;
            while(!boss.equals("root") && total != 0){
                int owe = total - total / 10;
                money.put(boss, money.get(boss) + owe);
                pass = total - owe;
                total = pass;
                boss = tree.get(boss);
            }
        }
        for(int i = 0; i < enroll.length; i++)
            answer[i] = money.get(enroll[i]);
        return answer;
    }
}
