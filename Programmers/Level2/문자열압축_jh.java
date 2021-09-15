//파이썬으로 많이 푼 문제였는데 코드를 자바 코드로 바꾸려니 너무 힘들다
// import java.util.*;
// class Solution {
//     public int solution(String s) {
//         int answer1 = 987654321;
//         int len = s.length();
//         int maxLen = (int)s.length() / 2;
//         if(len == 1) return 1;
//         for(int size = 1; size <= maxLen; size++){
//             String answer = "";
//             String prev = "";
//             int cnt = 1;
//             for(int idx = 0; idx < len / size; idx++){
//                 String st = s.substring(idx * size, idx * size + size);
//                 // System.out.println(st);
//                 // System.out.println(prev);
//                 // System.out.println(cnt);
//                 if(prev.equals("")) prev = st;
//                 else if(prev.equals(st)) cnt += 1;
//                 else if(!prev.equals(st)){
//                     if (cnt == 1){
//                         answer += prev;
//                         prev = st;
//                     }
//                     else{
//                         answer += Integer.toString(cnt) + prev;
//                         // System.out.println("여기"+answer);
//                         prev = st;
//                         cnt = 1;
//                     }
//                 }
//             }
//             if(cnt > 1) answer += Integer.toString(cnt) + prev;
//             else answer += prev;
//             if(len % size != 0){
//                 answer = answer + s.substring(len - (len%size), len);
//             }
//             // System.out.println(answer+ ' '+ answer1+ ' ' +answer.length());
//             answer1 = Math.min(answer1,answer.length());
//         }
//         return answer1;
//     }
// }


class Solution {
    public int solution(String s) {
        int answer = s.length();
        int maxLen = s.length() / 2;
        for(int len = 1; len <= maxLen; len++){
            int cnt = 1;
            String prev = "";
            String result = "";
            for(int idx = 0; idx + len <= s.length(); idx += len){
                String now = s.substring(idx, idx + len);
                if( prev.equals(now)) cnt++;
                else{
                    if(!prev.equals("")) result = result + (cnt == 1 ? prev : Integer.toString(cnt) + prev);
                    prev = now;
                    cnt = 1;
                } 
            }
            result = result + (cnt == 1 ? prev : Integer.toString(cnt) + prev);
            if(s.length() % len != 0) result += s.substring(s.length() - s.length() % len, s.length());
            answer = Math.min(result.length(), answer);
        }
        return answer;
    }
}
