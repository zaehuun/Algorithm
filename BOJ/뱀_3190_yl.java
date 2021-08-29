import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
3시간 - Cheating : O
Deque 몰라서 Queue로 풀다가 자꾸 틀림.
Deque으로 고치고 정답
*/
public class 뱀_3190_yl {
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 보드의 크기
        int[][] map = new int[N+2][N+2];
        int K = Integer.parseInt(br.readLine()); // 사과의 개수
        for (int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2] = 1; // 사과 위치
        }
        HashMap<Integer, Character> hm = new HashMap<>();
        int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
        for (int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            hm.put(n, c);
        }

        // 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1, 뱀은 처음에 오른쪽을 향한다.
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos (1, 1));

        //map[1][1] = -1; // 몸
        int sec = 0;
        Pos dir = new Pos (0, 1); // R
        // L : (0, -1)
        // R : (0, 1)
        // U : (-1, 0)
        // D : (1, 0)
        while (true) {
            sec++;
            // 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            Pos head = deque.peekFirst();
            map[head.y][head.x] = -1; // 몸
            int ny = head.y + dir.y;
            int nx = head.x + dir.x;
            if (ny == 0 || ny == N+1 || nx == 0 || nx == N+1) { // 벽에 부딪히면 게임 끝
                break;
            }
            deque.addFirst(new Pos(ny, nx));
            // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            if (map[ny][nx] == 1) {
                map[ny][nx] = -1; // 사과가 있던 칸을 머리로 채움
            }
            // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            else if (map[ny][nx] == 0) {
                Pos oldTail = deque.pollLast();
                map[oldTail.y][oldTail.x] = 0;
            }
            else if (map[ny][nx] == -1) { // 내 몸이랑 부딪히면 게임 끝
                break;
            }

            // 뱀의 방향 변환
            if (hm.containsKey(sec)) {
                int dirY = 0;
                int dirX = 0;
                if (hm.get(sec) == 'L') {
                    if (dir.y == 0 && dir.x == -1) { // L
                        dirY = 1;
                    }
                    else if (dir.y == 0 && dir.x == 1) { // R
                        dirY = -1;
                    }
                    else if (dir.y == -1 && dir.x == 0) { // U
                        dirX = -1;
                    }
                    else if (dir.y == 1 && dir.x == 0) { // D
                        dirX = 1;
                    }
                }
                else if (hm.get(sec) == 'D') { // 오른쪽
                    if (dir.y == 0 && dir.x == -1) { // L
                        dirY = -1;
                    }
                    else if (dir.y == 0 && dir.x == 1) { // R
                        dirY = 1;
                    }
                    else if (dir.y == -1 && dir.x == 0) { // U
                        dirX = 1;
                    }
                    else if (dir.y == 1 && dir.x == 0) { // D
                        dirX = -1;
                    }
                }
                dir = new Pos (dirY, dirX);
            }
        }
        System.out.println(sec);
    }
}
