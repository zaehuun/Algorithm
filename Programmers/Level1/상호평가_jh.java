class Solution {
    public String grade(double avg){
        if(avg < 50) return "F";
        if(avg < 70) return "D";
        if(avg < 80) return "C";
        if(avg < 90) return "B";
        return "A";
    }
    public String solution(int[][] scores) {
        String answer = "";
        int[] self = new int[scores.length];
        for(int i = 0; i < scores.length; i++)
            self[i] = scores[i][i];
        
        for(int i = 0; i < scores.length; i++){
            int sum = 0;
            double avg = 0;
            boolean isLow = true;
            boolean isHigh = true;
            for(int j = 0; j < scores.length; j++){
                if(j == i) continue; 
                if(scores[j][i] >= self[i]) isHigh = false;
                if(scores[j][i] <= self[i]) isLow = false;
                sum += scores[j][i];
            }
            if(!isHigh && !isLow) {
                sum+= self[i];
                avg = (double)sum/scores.length;
            }
            else{
                avg = (double)sum/(scores.length-1);
            }
            answer += grade(avg);
            
        }
        return answer;
    }
}
