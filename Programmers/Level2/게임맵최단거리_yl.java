import java.util.*;
/*
20분 - Cheating : X
BFS를 풀 떄는 전에 한 번 온 길을 다시 가는지 안가는지를 확인하자
다시 안 가는 거면 그냥 maps[i][j] == 0 아니면 continue 시키면 되니까
*/
class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Pos> q = new LinkedList<>();

        int destY = maps.length;
        int destX = maps[0].length;
        int[][] dist = new int[destY][destX];

        q.add(new Pos(0, 0));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int i=0; i<4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || ny >= destY || nx < 0 || nx >= destX) {
                    continue;
                }
                if (dist[ny][nx] != 0) {
                    continue;
                }
                if (maps[ny][nx] == 0) {
                    continue;
                }
                dist[ny][nx] = dist[p.y][p.x] + 1;
                q.add(new Pos(ny, nx));
            }
        }
        answer = dist[destY-1][destX-1] == 0 ? -1 : dist[destY-1][destX-1];
        return answer;
    }
}