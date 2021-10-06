import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
45분 - Cheating : X
*/
public class 바이러스_2606_yl {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]map = new int[n][n];
        boolean[] visited = new boolean[n];
        int x = Integer.parseInt(br.readLine());

        for (int i=0; i<x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        dfs(0, map, visited);

        int cnt = 0;
        for (int i=1; i<n; i++) {
            if (visited[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static void dfs (int n, int[][] map, boolean[] visited) {
        visited[n] = true;

        for (int i=0; i<map.length; i++) {
            if (map[n][i] == 1 && !visited[i]) {
                dfs(i, map, visited);
            }
        }
        return;
    }
}
