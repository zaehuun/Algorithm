import java.util.*;
/*
1시간 30분 - Cheating : X
그냥..구현만 살짝 복잡한 카카오 문제
*/
class Solution {
    public long solution(String expression) {
        long answer = 0;

        // expression 중 숫자만 추출
        String[] tmpNums = expression.split("[*+-]");
        ArrayList<Long> originNums = new ArrayList<>(); // 원본
        for (String s : tmpNums) {
            originNums.add(Long.parseLong(s));
        }

        // expression 중 연산자만 추출
        String tmpOperators = expression.replaceAll("[0-9]","");
        char[] chs = tmpOperators.toCharArray();
        ArrayList<Character> originOpers = new ArrayList<>();
        for (char c : chs) {
            originOpers.add(c);
        }

        // 연산자 우선순위 경우의 수
        String[] priorities = new String[]{"*+-", "*-+", "+-*", "+*-", "-+*", "-*+"};

        // 연산자 우선순위를 기준으로 연산
        for (int i=0; i<priorities.length; i++) {
            ArrayList<Long> nums = new ArrayList<>();
            nums.addAll(originNums);
            ArrayList<Character> opers = new ArrayList<>();
            opers.addAll(originOpers);

            for (int j=0; j<3; j++) { // *, +, - 1개씩 계산
                char op = priorities[i].charAt(j);

                while (opers.contains(op)) { // expression에 현재 연산자가 남아있다면
                    int idx = opers.indexOf(op);
                    long num1 = nums.remove(idx);
                    long newVal = 0;
                    if (op == '+') {
                        newVal = num1 + nums.get(idx);
                    }
                    else if (op == '-') {
                        newVal = num1 - nums.get(idx);
                    }
                    else if (op == '*') {
                        newVal = num1 * (nums.get(idx));
                    }
                    nums.set(idx, newVal);
                    opers.remove(idx);
                }
            }
            answer = Math.max(answer, (long)Math.abs(nums.get(0)));
        }
        return answer;
    }
}