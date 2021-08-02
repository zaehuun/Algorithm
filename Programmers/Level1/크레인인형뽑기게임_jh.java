import java.util.*;
class 크레인인형뽑기게임_jh {
  public static void main(String[] args) {
    int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    int[] moves = {1,5,3,5,1,2,1,4};
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
        // return answer;
    }
}
