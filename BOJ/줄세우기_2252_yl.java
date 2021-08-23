import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1시간 - Cheating : O
*/
public class 줄세우기_2252_yl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 비교 회수

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        // ArrayList 초기화
        for (int i=0; i<n+1; i++) {
            al.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[n+1]; // 해당 원소를 가리키는 원소의 개수
        for (int i=0; i<m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int student1 = Integer.parseInt(st1.nextToken());
            int student2 = Integer.parseInt(st1.nextToken());

            al.get(student1).add(student2); // student1 -> student2
            indegree[student2]++; // student2를 가리키고 있는애가 1개 늘어남
        }

        // 시작점 찾기 (아무도 안 가리키는 애) / Queue에는 아무도 자기를 안 가리키는 애가 들어간다.
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<n+1; i++) {
            if (indegree[i] == 0) {
                q.add(i); // indegree[i] 아님 주의 !
            }
        }

        ArrayList<Integer> ansAl = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            ansAl.add(cur);
            // cur가 가리키는 화살표들을 삭제함
            for (Integer elem : al.get(cur)) {
                indegree[elem]--;
                if (indegree[elem] == 0) {
                    q.add(elem);
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.print(ansAl.get(i)+" ");
        }

    }
}
