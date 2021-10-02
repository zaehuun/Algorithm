import java.util.*;
class Solution {
    public class boxer implements Comparable<boxer>{
        float rate;
        int overWin;
        int weight;
        int number;
        
        public boxer(float rate, int overWin, int weight, int number){
            this.rate = rate;
            this.overWin = overWin;
            this.weight = weight;
            this.number = number;
        }
        
        @Override
        public int compareTo(boxer b) {
            if(rate == b.rate){
                if(overWin > b.overWin) return -1;
                if(overWin < b.overWin) return 1;
                
                if(weight > b.weight) return -1;
                if(weight < b.weight) return 1;
                
                if(number < b.number) return -1;
                if(number > b.number) return 1;
            }
            if(rate < b.rate) return 1;
            return -1;
        }
    }
    public int[] solution(int[] weights, String[] head2head) {
        
        int boxerCount = head2head.length;
        
        List<boxer> list = new ArrayList<>();
        for(int i = 0; i < boxerCount; i++){
            int win = 0;
            int gameCount = 0;
            int overWin = 0;
            int weight = weights[i];
            int number = i;
            
            for(int j = 0; j < boxerCount; j++){
                char result = head2head[i].charAt(j);
                if(result == 'N') continue;
                if(result == 'W') {
                    win++;
                    if(weights[i] < weights[j]) overWin++;
                }
                gameCount++;
            }
            float rate = gameCount == 0 ? 0f : (float)win/gameCount;
            list.add(new boxer(rate, overWin, weight, number));
        }
        Collections.sort(list);
        int[] answer = new int[boxerCount];
        for(boxer b : list){
            System.out.println(b.rate + " " + b.weight + " " + b.overWin + " " + b.number);
        }
        for(int i = 0; i < boxerCount; i++)
            answer[i] = list.get(i).number + 1;
        
        return answer;
    }
}
