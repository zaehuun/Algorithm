import java.util.*;
/*
20분 - Cheating : X
*/
class Solution {
    public int solution(String word) {
        int answer = 0;
        for (int i=0; i<5; i++) {
            boolean[] visited = new boolean[5];
            permu ("", "AEIOU", 0, i+1, visited);
        }
        Collections.sort(al);
        answer = al.indexOf(word) + 1;
        return answer;
    }
    static ArrayList<String> al = new ArrayList<>();
    private static void permu (String s, String word, int depth, int len, boolean[] visited) {
        if (len == s.length()) {
            if (!al.contains(s)) {
                al.add(s);
            }
            return;
        }
        for (int i=0; i<5; i++) {
            visited[i] = true;
            permu (s+word.charAt(i), word, depth+1, len, visited);
            visited[i] = false;
        }
    }
}