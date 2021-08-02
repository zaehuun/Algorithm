import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int row = board.length;        
        for(int m : moves){
            m = m - 1;
            for(int r = 0; r < row; r++){
                if(board[r][m] != 0){
                    // System.out.println(board[r][m]);
                    if(stack.empty()) stack.push(board[r][m]);
                    else{
                        if(stack.peek() == board[r][m]){
                            stack.pop();
                            answer += 2;
                        }
                        else stack.push(board[r][m]);
                    }
                    board[r][m] = 0;
                    // System.out.println(stack.toString());
                    break;
                }
            }
        }
        return answer;
    }
}
