/*
1시간 - Cheating : X
*/
class Solution {
    static int answer = 0;
    public int solution(int n, String[] data) {
        answer = 0;
        boolean[] visited = new boolean[8];
        String[] members = {"A","C","F","J","M","N","R","T"};
        permutation (0, "", visited, data, members);
        return answer;
    }
    private static void permutation(int depth, String s, boolean[] visited, String[] data, String[] members) {
        if (depth == 8) {
            for (int i=0; i<data.length; i++) {
                int val = data[i].charAt(4)-'0';
                int indexDiff = Math.abs(s.indexOf(data[i].charAt(0)) - s.indexOf(data[i].charAt(2))) - 1;
                char op = data[i].charAt(3);
                if (op == '=') {
                    if (indexDiff != val){
                        return;
                    }
                }
                else if (op == '>') {
                    if (indexDiff <= val) {
                        return;
                    }

                }
                else if (op == '<') {
                    if (indexDiff >= val) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }

        for (int i=0; i<8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(depth+1, s+members[i], visited, data, members);
                visited[i] = false;
            }
        }
    }
}