import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
2시간 - Cheating : X
이렇게 푸는게 맞나 긴가민가했는데 맞았다! 만세!
*/
public class 아기상어_16236_yl {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N = 0;
    static Pos babyShark = new Pos (-1, -1); // 아기상어 위치
    static int babySharkVal = 2; // 아기상어 크기 (2부터 시작)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 아기상어 시작 위치 저장하고 map에는 0으로 표시
                    map[i][j] = 0;
                    babyShark = new Pos(i, j);
                }
            }
        }

        int fishCnt = 0;
        while (true) {
            // 다음에 이동할 곳 찾기 - 물고기 먹을 수 있는 곳(아기상어 보다 작은 곳) 우선
            Pos minDistPos = findClosestFish(map);
            if (minDistPos.y == -1 && minDistPos.x == -1) { // 더 이상 움직일 곳 없으면 break
                break;
            }
            // 이동
            if (map[minDistPos.y][minDistPos.x] < babySharkVal) {
                fishCnt++;
                if (fishCnt == babySharkVal) {
                    babySharkVal++;
                    fishCnt = 0;
                }
                map[minDistPos.y][minDistPos.x] = 0;
                babyShark = new Pos(minDistPos.y, minDistPos.x);
            }
        }
        System.out.println(sec);
    }

    static int sec = 0;
    private static Pos findClosestFish(int[][] map) {
        int[][] dist = new int[N][N];
        Queue<Pos> q = new LinkedList<>();
        int minDist = Integer.MAX_VALUE;
        Pos minDistPos = new Pos(-1, -1);
        q.add(babyShark);
        dist[babyShark.y][babyShark.x] = 1;

        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int i=0; i<4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }
                if (dist[ny][nx] != 0 || map[ny][nx] > babySharkVal) {
                    continue;
                }
                dist[ny][nx] = dist[p.y][p.x] + 1;
                q.add(new Pos(ny, nx));
                if (map[ny][nx] > 0 && babySharkVal > map[ny][nx]) { // 아기 상어보다 작은 것 중 제일 가까운 것 구하기
                    if (minDist > dist[ny][nx]) {
                        minDist = dist[ny][nx];
                        minDistPos = new Pos(ny, nx);
                    }
                    else if (minDist == dist[ny][nx]) { // 거리가 가까운 물고기가 많다면,
                        if (minDistPos.y > ny) { // 가장 위에 있는 물고기
                            minDist = dist[ny][nx];
                            minDistPos = new Pos(ny, nx);
                        }
                        else if (minDistPos.y == ny) { // 가장 위에 있는 물고기가 여러마리면, 가장 왼쪽에 있는 물고기를 먹음
                            if (minDistPos.x > nx) {
                                minDist = dist[ny][nx];
                                minDistPos = new Pos(ny, nx);
                            }
                        }
                    }
                }
            }
        }
        if (minDist != Integer.MAX_VALUE) {
            sec += minDist - 1; // 1부터 시작했으니까 -1
        }
        return minDistPos;
    }
}
