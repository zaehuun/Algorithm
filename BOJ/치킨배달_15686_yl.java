import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
2시간 30분 - Cheating : O
조합 돌리고 BFS 쓰는 건 줄 알았는데 시초나서
문제에서 주어진 식으로 해결함. 문제가 시키는대로 하자 ^^
*/
public class 치킨배달_15686_yl {
    static ArrayList<boolean[]> al = new ArrayList<>(); // 모든 경우의 수
    static class Pos {
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        // 43
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 치킨집 최대 개수
        int[][] originMap = new int[N][N];

        ArrayList<Pos> house = new ArrayList<>();
        int chickenCnt = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                originMap[i][j] = Integer.parseInt(st1.nextToken());
                if (originMap[i][j] == 2) {
                    chickenCnt++;
                }
                if (originMap[i][j] == 1) {
                    house.add(new Pos(i, j));
                }
            }
        }

        combination(0, new boolean[chickenCnt], M);

        int answer = Integer.MAX_VALUE;
        for (int x=0; x<al.size(); x++) { // combination으로 구한 모든 치킨집 조합에서 집이랑 가장 가까운 거리 구하기
            boolean[] bool = al.get(x);
            int boolIdx = 0;
            ArrayList<Pos> chicken = new ArrayList<>();
            for (int i=0; i<bool.length; i++) {
                System.out.print(bool[i]+" ");
            }
            System.out.println();
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (originMap[i][j] == 2) {
                        if (bool[boolIdx]) {
                            chicken.add(new Pos(i, j));
                        }
                        boolIdx++;
                    }
                }
            }
            int cnt = 0;
            for (int i=0; i<house.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j=0; j<chicken.size(); j++) {
                    int dist = Math.abs(house.get(i).y - chicken.get(j).y) + Math.abs(house.get(i).x - chicken.get(j).x);
                    min = Math.min(min, dist);
                }
                cnt += min;
            }
            answer = Math.min(cnt, answer);

        }
        System.out.println(answer);

    }
    private static void combination (int startIdx, boolean[] chicken, int chickenMax) {
        int cnt = 0;
        for (int i=0; i<chicken.length; i++) {
            if (chicken[i]) {
                cnt++;
            }
        }
        if (cnt == chickenMax){
            boolean[] chickenCopy = chicken.clone();
            al.add(chickenCopy); // clone 안 하고 chicken 넣으니까 주소값 복사돼서 같은것만 들어감
            return;
        }
        for (int i=startIdx; i<chicken.length; i++) {
            if (!chicken[i]) {
                chicken[i] = true;
                combination(i+1, chicken, chickenMax);
                chicken[i] = false;
            }
        }
    }
    // static int answer = Integer.MAX_VALUE;
    // private static void findAnswer(int[][] originMap) { // 다시 만든 map을 바탕으로 최소값 구하기
    //     for (int x=0; x<al.size(); x++) {
    //         int[][] map = makeMap(originMap, x);
    //         int chickenDistCnt = 0;
    //         for (int i=0; i<map.length; i++) {
    //             for (int j=0; j<map[0].length; j++) {
    //                 if (map[i][j] == 1) {
    //                     int cnt = findCloestChicken(i, j, map);
    //                     chickenDistCnt += cnt;
    //                 }
    //             }
    //         }
    //         answer = Math.min(answer, chickenDistCnt);
    //     }
    // }

    // private static int findCloestChicken (int y, int x, int[][] map) {
    //     System.out.println(y+" "+x);
    //     int dist[][] = new int[map.length][map[0].length];
    //     Queue<Pos> q = new LinkedList<>();
    //     q.add(new Pos(y, x));
    //     int cnt = 0;
    //     while (!q.isEmpty()) {
    //         Pos p = q.poll();

    //         for (int i=0; i<4; i++) {
    //             int ny = p.y + dy[i];
    //             int nx = p.x + dx[i];

    //             if (ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
    //                 // System.out.println("--"+ny+" "+nx);
    //                 if (dist[ny][nx] == 0) {
    //                     dist[ny][nx] = dist[p.y][p.x] + 1;
    //                     q.add(new Pos(ny, nx));
    //                     if (map[ny][nx] == 2) {
    //                         cnt = dist[ny][nx];
    //                         // System.out.println("cnt = "+cnt);
    //                         return cnt;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     // System.out.println("cnt = "+cnt);
    //     return cnt;
    // }

    // private static int[][] makeMap(int[][] originMap, int x) { // 조합으로 만든 경우의 수를 바탕으로 다시 map 생성
    //     boolean[] bool = al.get(x);
    //     // for (int i=0; i<3; i++) {
    //     //     System.out.print(bool[i]+" ");
    //     // }
    //     // System.out.println();
    //     int idx = 0;
    //     int[][] map = new int[originMap.length][originMap[0].length];
    //     for (int i=0; i<originMap.length; i++) {
    //         for (int j=0; j<originMap[0].length; j++) {
    //             map[i][j] = originMap[i][j];
    //             if (originMap[i][j] == 2) {
    //                 if (!bool[idx]) {
    //                     map[i][j] = 0;
    //                 }
    //                 idx++;
    //             }
    //         }
    //     }

    //     // System.out.println();
    //     // for (int i=0; i<originMap.length; i++) {
    //     //     for (int j=0; j<originMap[0].length; j++) {
    //     //         System.out.print(map[i][j]+" ");
    //     //     }
    //     //     System.out.println();
    //     // }
    //     // System.out.println();
    //     return map;
    // }
}
