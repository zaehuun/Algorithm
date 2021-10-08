/*
8분 - Cheating : X
*/
class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        int nOneCnt = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                nOneCnt++;
            }
        }
        while (true) {
            n++;
            String str = Integer.toBinaryString(n);
            int tmp = 0;
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) == '1') {
                    tmp++;
                }
            }
            if (tmp == nOneCnt) {
                break;
            }
        }
        return n;
    }
}