/*
40분 - Cheating : X
*/
import java.util.*;
class Solution {
    static String[] answer;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        answer = new String[tickets.length+1];
        for (int i=0; i<tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean[] visited = new boolean[tickets.length];
                visited[i] = true;
                String[] arr = new String[tickets.length+1];
                dfs (0, tickets[i][1], tickets[i][0]+" "+tickets[i][1], visited, tickets);
            }
        }
        return answer;
    }

    private static void dfs (int depth, String s, String total, boolean[] visited, String[][] tickets) {
        if (depth == tickets.length - 1 && answer[0] == null) {
            answer = total.split(" ");
            return;
        }
        for (int i=0; i<visited.length; i++) {
            if (s.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs (depth+1, tickets[i][1], total+" "+tickets[i][1], visited, tickets);
                visited[i] = false;
            }
        }
    }
}