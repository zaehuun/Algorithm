import java.util.Stack;
/*
53분 - Cheating : X
스택 사용법 다시 익히는데 오래걸렸다.
st.pop() => Object를 리턴한다.
  */
public class 크레인인형뽑기게임_yl {
  public static void main(String[] args) {
    int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    int[] moves = {1,5,3,5,1,2,1,4};

    int answer = 0;

    // 일단 board를 stArr에 다 넣음
    Stack[] stArr = new Stack[board.length];
    for (int i=0; i<board.length; i++) {
      Stack<Integer> st = new Stack<>();
      for (int j=0; j<board[i].length; j++) {
        if (board[board.length-j-1][i] != 0) {
          st.push(board[board.length-j-1][i]);
        }
      }
      stArr[i] = st;
    }
    // stArr에서 뽑으면서 검사
    Stack<Integer> resSt = new Stack<>();
    for (int i=0; i<moves.length; i++) {
      if (stArr[moves[i]-1].size() > 0) {
        Integer popVal = (Integer)stArr[moves[i]-1].pop();
        if (!resSt.isEmpty() && resSt.peek() == popVal) {
          resSt.pop();
          answer += 2;
        }
        else if ((!resSt.isEmpty() && resSt.peek() != popVal) || resSt.isEmpty()) {
          resSt.push(popVal);
        }

      }
    }
  }
}
