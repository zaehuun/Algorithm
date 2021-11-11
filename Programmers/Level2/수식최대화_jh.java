import java.util.*;
class Solution {
    boolean[] visit = new boolean[3];
    List<Long> num = new ArrayList<>();
    List<Character> ex = new ArrayList<>();
    long answer = 0;
    public void permutation(char[] t, List<Character> list, String expression){
        if(list.size() == 3){
            List<Long> cnum = new ArrayList<Long>(num);
            List<Character> cex = new ArrayList<Character>(ex);
            
            for(char c: list){
                while(cex.contains(c)){
                    int idx = cex.indexOf(c);
                    cex.remove(idx);
                    long num1 = cnum.get(idx);
                    long num2 = cnum.get(idx+1);
                    long result;
                    if(c == '+') result = num1+num2;
                    else if(c == '-') result = num1-num2;
                    else result = num1*num2;
                    
                    cnum.remove(idx+1);
                    cnum.remove(idx);
                    
                    cnum.add(idx, result);
                    
                }
            }
            answer = Math.max(answer, Math.abs(cnum.get(0)));
            return;
        }
        for(int i = 0; i < 3; i++){
            if(visit[i]) continue;
            visit[i] = true;
            list.add(t[i]);
            permutation(t, list, expression);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
    public long solution(String expression) {
        char[] t = {'*','+','-'};
        String tmp = "";
        for(char c : expression.toCharArray()){
            if(c >= '0' && c <= '9'){
                tmp = tmp + c;
            }  
            else{
                num.add(Long.parseLong(tmp));
                ex.add(c);
                tmp = "";
            }
        }
        num.add(Long.parseLong(tmp));
        permutation(t, new ArrayList<Character>(), expression);
        return answer;
    }
}
