import java.util.*;
/*
3시간 - Cheating : O
HashSet에서 containsAll 쓸수있는걸 진작 알았으면 좋았으련만 ^^ 그냥 전형적인 복잡하고 오래걸리는 카카오문제
*/
class Solution {
    static ArrayList<HashSet<Integer>> ans = new ArrayList<>();
    public int solution(String[][] relation) {
        int n = relation[0].length; // 컬럼 개수
        for (int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n];
            String[] str = new String[n];
            combi (i, 0, "", visited, relation, 0);
        }
        return ans.size();
    }
    private static void combi (int len, int depth, String s, boolean[] visited, String[][] relation, int before) {
        if (depth == len) {
            String[] splited = s.split(" ");
            // 해당 경우의 수를 HashSet으로 만들기
            HashSet<Integer> tmpCase = new HashSet<>();
            HashSet<String> tmpCaseRow = new HashSet<>(); // 해당 경우의 수로 조합한 총 row 수
            for (int i=0; i<splited.length; i++) {
                if (!splited[i].equals("")) {
                    tmpCase.add(Integer.parseInt(splited[i]));
                }
            }
            for (int i=0; i<relation.length; i++) {
                String str = "";
                for (int tmpCaseItem : tmpCase) {
                    str += relation[i][tmpCaseItem];
                }
                tmpCaseRow.add(str);
            }

            if (tmpCaseRow.size() == relation.length) { // tmp가 유일성을 만족한다면
                for (HashSet<Integer> ansItem : ans) { // tmp가 ans.get(i)를 모두 포함하는게 있는지 확인
                    if (tmpCase.containsAll(ansItem)) {
                        return;
                    }
                }
                ans.add(tmpCase);
            }
        }
        for (int i=before; i<relation[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(len, depth+1, s+" "+Integer.toString(i), visited, relation, i+1);
                visited[i] = false;
            }
        }
    }
}