import java.util.*;
/*
1시간 - Cheating : X
? 카카오 인턴문제를 생각보다 쉽게 풀어버렸다. 윤리둥절
*/
class Solution {
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        // P 응시자
        // O 빈 테이블
        // X 파티션
        int h = 5;
        int w = 5;
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        for (int x=0; x<places.length; x++) {
            String[] map = places[x];

            // 1. 응시자(P)가 앉아있는 곳 ArrayList에 저장
            ArrayList<Pos> participants = new ArrayList<>();
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (map[i].charAt(j) == 'P') {
                        participants.add(new Pos(i, j));
                    }
                }
            }

            // 2. for문 돌면서 한 P부터 나머지 모든 P까지 확인
            for (int i=0; i<participants.size(); i++) {
                Pos pStart = participants.get(i);

                for (int j=i+1; j<participants.size(); j++) {
                    // pStart ~ pEnd 까지 경로 구하기
                    boolean[][] visited = new boolean[h][w];
                    int[][] dist = new int[h][w];
                    Pos pEnd = participants.get(j);

                    Queue<Pos> q = new LinkedList<>();
                    q.add(pStart);

                    boolean partitionFlag = false;
                    boolean breakFlag = false;
                    while (!q.isEmpty()) {
                        Pos p = q.poll();
                        if (p.y == pEnd.y && p.x == pEnd.x) {

                            // 파티션(X)로 가려있다는거니까 거리두기 지킨 것
                            if (dist[p.y][p.x] == 0 && answer[x] == 0) {
                                answer[x] = 1;
                            }
                            if (dist[p.y][p.x] <= 2) {
                                answer[x] = 0;
                            }
                            break;
                        }

                        for (int k=0; k<4; k++) {
                            int ny = p.y + dy[k];
                            int nx = p.x + dx[k];

                            if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                                if (map[ny].charAt(nx) == 'X') {
                                    continue;
                                }
                                if (map[ny].charAt(nx) == 'X') {
                                    partitionFlag = true;
                                }
                                if (visited[ny][nx]) {
                                    continue;
                                }

                                dist[ny][nx] = dist[p.y][p.x] + 1;
                                visited[ny][nx] = true;
                                q.add(new Pos(ny, nx));
                            }
                        }
                        if (breakFlag) {
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}