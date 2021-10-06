import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
20분 - Cheating : X
*/
public class 유기농배추_1012_yl {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        for (int x=0; x<N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            for (int y=0; y<n; y++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st1.nextToken());
                int n2 = Integer.parseInt(st1.nextToken());
                map[n2][n1] = 1;
            }
            int cnt = 0;
            for (int i=0; i<h ;i++) {
                for (int j=0; j<w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        // System.out.println("i = "+i+" j = "+j);
                        cnt++;
                        dfs(i, j, map, visited);
                    }
                }
            }

            answer[x] = cnt;
            // for (int i=0; i<h ;i++) {
            //     for (int j=0; j<w; j++) {
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        for (int i=0; i<N; i++) {
            System.out.println(answer[i]);
        }

    }
    private static void dfs (int y, int x, int[][] map, boolean[][] visited) {
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) {
                continue;
            }
            if (visited[ny][nx] || map[ny][nx] == 0) {
                continue;
            }

            // System.out.println("ny = "+ny+", nx = "+nx);
            visited[ny][nx] = true;
            dfs(ny, nx, map, visited);
        }

    }
}
