import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
40분 - Cheating : X
맞긴 했는데 메모리 & 시간 효율 엄청 떨어짐
한 번 방문한 곳은 다시 안 가도 된다.
*/
public class 알파벳_1987_yl {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 세로
        int C = Integer.parseInt(st.nextToken()); // 가로
        char[][] map = new char[R][C];
        for (int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder(Character.toString(map[0][0]));
        dfs(0, 0, sb, map);
        System.out.println(answer);

    }
    static int answer = 1;
    private static void dfs (int y, int x, StringBuilder sb, char[][] map) {
        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
                if (sb.indexOf(Character.toString(map[ny][nx])) == -1) {
                    sb.append(Character.toString(map[ny][nx]));
                    answer = Math.max(answer, sb.length());
                    dfs (ny, nx, sb, map);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}
