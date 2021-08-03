class Solution {
  static class Pos{
      int y;
      int x;
      Pos (int y, int x) {
          this.y = y;
          this.x = x;
      }
  }
  public String solution(int[] numbers, String hand) {
      String answer = "";
      Pos[] arr = {new Pos(3, 1), new Pos(0, 0), new Pos(0,1), new Pos(0, 2),
                   new Pos(1, 0), new Pos(1, 1), new Pos(1, 2),
                   new Pos(2, 0), new Pos(2, 1), new Pos(2, 2)};

      Pos befRight = new Pos(3, 2);
      Pos befLeft = new Pos(3, 0);
      for (int i=0; i<numbers.length; i++) {
          if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
              answer += 'L';
              befLeft = arr[numbers[i]];
          }
          else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
              answer += 'R';
              befRight = arr[numbers[i]];
          }
          else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
              // 더 가까운거
              Pos cur = arr[numbers[i]];
              //int leftDist = (int)Math.pow(cur.y - befLeft.y, 2) + (int)Math.pow(cur.x - befLeft.x, 2); 왠지 모르겠는데 에러남
              //int rightDist = (int)Math.pow(cur.y - befRight.y, 2) + (int)Math.pow(cur.x - befRight.x, 2); 왠지 모르겠는데 에러남
              int leftDist = Math.abs(cur.y - befLeft.y) + Math.abs(cur.x - befLeft.x);
              int rightDist = Math.abs(cur.y - befRight.y) + Math.abs(cur.x - befRight.x);

              if (leftDist < rightDist) {
                  answer += 'L';
                  befLeft = arr[numbers[i]];
              }
              else if (leftDist > rightDist) {
                  answer += 'R';
                  befRight = arr[numbers[i]];
              }
              else {
                  // 거리가 같으면 무슨손잡이인지
                  if (hand.equals("right")) {
                      answer += 'R';
                      befRight = arr[numbers[i]];
                  }
                  else if (hand.equals("left")) {
                      answer += 'L';
                      befLeft = arr[numbers[i]];
                  }
              }
          }
      }
      return answer;
  }
}