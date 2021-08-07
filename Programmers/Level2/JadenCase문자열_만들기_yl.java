/*
40분 - Cheating : O
런타임 에러 - 공백이 여러 개 들어갈 수 있는걸 생각을 못 함 ㅂㄷㅂㄷ
*/
class Solution {
  public String solution(String s) {
      StringBuilder answer = new StringBuilder();

      for (int i=0; i<s.length(); i++) {
          String letter = Character.toString(s.charAt(i));
          if (i == 0 || (i>0 && s.charAt(i-1) == ' ')) {
              if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                  letter = Character.toString(s.charAt(i)).toUpperCase();
              }
          }
          else {
              if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                  letter = Character.toString(s.charAt(i)).toLowerCase();
              }
          }
          answer.append(letter);
      }
      return answer.toString();
  }
}