/*
30분 - Cheating : O
Math.abs(a-b)만 하면 안 되고
n = 8, a = 4, b = 5 일 떄를 생각해야함
*/
class Solution {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (true) {
            answer++;
            if (Math.abs(a-b) == 1 && Math.max(a, b) % 2 == 0) {
                break;
            }
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;
        }
        return answer;
    }
}