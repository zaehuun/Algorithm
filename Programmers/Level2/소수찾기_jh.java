import java.util.*;
class Solution {
    List<Integer> arr = new ArrayList<>();
    public void permutation(String numbers, boolean[] visit, int cnt, int total, String now){
        if(total == cnt){
            int num = Integer.parseInt(now);
            if(!arr.contains(num)) arr.add(num);
        } 
        else{
            for(int i = 0; i < numbers.length(); i++){
                if(!visit[i]){
                    visit[i] = true;
                    permutation(numbers,visit,cnt + 1, total, now + String.valueOf(numbers.charAt(i)));
                    visit[i] = false;                                
                }
            }
        }
        
    }
    public int solution(String numbers) {
        int answer = 0;
        for(int i = 1; i <= numbers.length(); i++){
            boolean[] visit = new boolean[numbers.length()];
            permutation(numbers,visit,0,i, "");
        }
        int max = Collections.max(arr);
        System.out.println(max);
        boolean[] isPrime = new boolean[max+1];
        isPrime[0] = isPrime[1] = true;
        for(int i = 2; i * i <= max; i++){
            if(!isPrime[i]){
                for(int j = i * i; j <= max; j += i)
                    isPrime[j] = true;
            }
        }
        for(int num : arr){
            if(!isPrime[num]) answer++;
        }
        return answer;
    }
}
