import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1시간 25분 - Cheating : X
0 >= 이 범위에 = 빠트려서 시간 개잡아먹음 굉장히 화난다. 하지만 맞았으니 봐줌.
*/
public class 로봇청소기_14503_yl {
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[] dyLeft = {0, -1, 0, 1}; // 북: x-1, 동: y-1, 남: x+1, 서: y+1
    static int[] dxLeft = {-1, 0, 1, 0};// 0 -> 3, 1->0, 2-> 1, 3-> 2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st1.nextToken()); // (r, c)
        int x = Integer.parseInt(st1.nextToken());
        int d = Integer.parseInt(st1.nextToken()); // 0:북, 1:동, 2:남, 3:서
        for (int i=0; i<h; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        boolean[][] cleaned = new boolean[h][w];
        cleaned[y][x] = true;
        int answer = 1;
        while (true) {
            int cantgo = 0;
            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (map[ny][nx] == 1 || cleaned[ny][nx]) {
                    cantgo++;
                }
            }

            if (cantgo == 4) {
                // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                y += dy[d] * -1;
                x += dx[d] * -1;

                // 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                if (map[y][x] == 1) {
                    break;
                }
                continue;
            }

            int leftY = y + dyLeft[d];
            int leftX = x + dxLeft[d];
            if (leftY >= 0 && leftY < h && leftX >= 0 && leftX < w) {
                d = d == 0? 3 : d-1;
                if (map[leftY][leftX] == 0 && !cleaned[leftY][leftX]) { // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                    cleaned[leftY][leftX] = true;
                    y = leftY;
                    x = leftX;
                    answer++;
                    continue;
                }
            }
        }
        System.out.println(answer);
    }
}