class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i <= yellow; i++){
            if(yellow % i != 0) continue;
            int yellow_col = yellow / i;
            int yellow_row = yellow / yellow_col;
            
            int total_col = yellow_col + 2;
            int total_row = yellow_row + 2;
            
            if(total_col * total_row - yellow_col * yellow_row == brown){
                answer[0] = total_col;
                answer[1] = total_row;
                break;
            }
        }
        return answer;
    }
}
