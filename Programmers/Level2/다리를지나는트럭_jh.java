import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        int length = truck_weights.length;
        int sum = 0;
        int idx = 0;
        while(true){
            int w = bridge.poll();
            if(w != 0) {length--; sum-=w;}
            if(length == 0) {answer++;break;}
            if(idx < truck_weights.length && sum + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                sum+=truck_weights[idx];
                idx++;
            }
            else{
                bridge.offer(0);
            }
            // System.out.println(bridge);
            answer++;
        }
        return answer;
    }
}
