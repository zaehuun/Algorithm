/*
1시간 14분 - Cheating : O
힘들게풀었다. 뭔가 dp나 큐로 최적화 될것같은데 알고보니 3중포문이었다.
문자열 길이만큼 첫번째 for문 돌면서 (제일긴것부터) 답 나오면 바로 return 해서 시초 방지하는게 포인트
그리고 answer최소값은 0이 아니라 1이다 ㅠ 한글자도 팰린드롬으로 치나봄 ㅎ..
*/
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        for (int i=s.length(); i>=2; i--) { // 문자열 길이
            for (int j=0; j<=s.length()-i; j++) { // 시작 문자열
                boolean isPalindrome = true;
                for (int k=0; k<i/2; k++) {
                    if (s.charAt(j+k) != s.charAt((i+j)-k-1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    answer = i;
                    return i;
                }
            }
        }
        return answer;
    }
}