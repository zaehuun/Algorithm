import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
25분 - Cheating : X
*/
public class 단지번호붙이기_2667_yl {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 지도의 크기

        int[][] map = new int[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        boolean[][] visited = new boolean[n][n];
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs (i, j, map, visited);
                    al.add(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(al.size());
        Collections.sort(al);
        for (int i=0; i<al.size(); i++) {
            System.out.println(al.get(i));
        }

    }
    static int cnt = 1;
    private static void dfs (int y, int x, int[][] map, boolean[][] visited) {
        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < map.length && nx >= 0 && nx < map.length) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    cnt++;
                    visited[ny][nx] = true;
                    dfs (ny, nx, map, visited);
                }
            }
        }
    }
}
