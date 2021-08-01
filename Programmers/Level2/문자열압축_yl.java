/*
1시간 30분 - Cheating : O
이 문제 포인트
: 1. makeCompressedStr 메소드를 분리해서 가독성 향상
  2. subStrArr의 맨 뒤에 '!' 추가해서 맨 뒤까지 검사 (추가 안 하면 맨 끝글자가 res에 안 들어감)

String보다는 StringBuffer를 사용하자. String은 새로운 값을 할당할 때마다 새로 생성되지만, StringBuffer는 memory에 append하는 방식으로 클래스를 직접 생성하지 않는다.
(클래스가 생성될 때 method들과 variable도 같이 생성되는데, StringBuffer는 이런 시간을 사용하지 않는다.)
  */
public class 문자열압축_yl {
    public static void main(String[] args) {
        String s = "aabbaccc";
        // String s = "ababcdcdababcdcd";
        // String s = "ababcdcdababcdcd";
        // String s = "abcabcdede";
        // String s = "abcabcabcabcdededededede";
        // String s = "xababcdcdababcdcd";

        int answer = s.length();

        for (int i=1; i<=s.length()/2; i++) {
            // 맨 뒤에 한 칸 더 추가해서 알파벳이 아닌 문자를 하나 넣어줌 ex.! (그래야 맨 끝까지 비교 가능)
            String subStrArr[] = new String[(s.length()%i == 0? s.length()/i : s.length()/i + 1) + 1];
            int idx = 0;
            for (int j=0; j<s.length(); j+=i) {
                subStrArr[idx] = s.substring(j, Math.min(j+i, s.length()));
                idx++;
            }
            subStrArr[idx] = "!";
            String compressedStr = makeCompressedStr(subStrArr);
            answer = answer > compressedStr.length() ? compressedStr.length() : answer;
            if (answer > compressedStr.length()) {
                answer = compressedStr.length();
            }
        }
        System.out.println(answer);
    }

    // 압축된 문자열로 만들기
    private static String makeCompressedStr(String[] arr) {
        String res = "";
        int repeatNum = 1;

        for (int i=0; i<arr.length-1; i++) {
            if (arr[i].equals(arr[i+1])) {
                repeatNum++;
            }
            else {
                res += (repeatNum == 1? "" : Integer.toString(repeatNum)) + arr[i];
                repeatNum = 1;
            }
        }
        return res;
    }
}
