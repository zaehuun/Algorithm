import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
1시간 10분 - Cheating : X
그냥..ArrayList를 사용하면 될 뿐..구현은 짜증나지만 테케 하나 맞으면 다 맞는 그런 문제..
*/
public class PuyoPuyo_11559_yl {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static class Pos implements Comparable<Pos>{
        int y;
        int x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
        public int compareTo (Pos p) {
            return p.x - this.x;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = 12;
        int w = 6;
        ArrayList<ArrayList<Character>> al = new ArrayList<>(); // 터뜨리기 용
        for (int i=0; i<w; i++) {
            al.add(new ArrayList<Character>());
        }
        // al 맵으로 만들기
        char[][] tmp  = new char[h][w];
        for (int i=0; i<h; i++) {
            String s = br.readLine();
            for (int j=0; j<w; j++) {
                tmp[i][j] = s.charAt(j);
            }
        }
        for (int i=0; i<w; i++) {
            for (int j=h-1; j>=0; j--) {
                al.get(i).add(tmp[j][i]);
            }
        }

        int answer = 0;
        // 터뜨리기
        while (true) {
            answer++;
            boolean[][] visited = new boolean[w][h];
            ArrayList<Pos> willBeDeleted = new ArrayList<>();
            // 터뜨릴거 저장하기
            for (int i=0; i<al.size(); i++) {
                for (int j=0; j<al.get(i).size(); j++) {
                    if (al.get(i).get(j) != '.' && !visited[i][j]) {
                        maxCnt = 1;
                        chainedTmpAl.clear();
                        isChained(i, j, al.get(i).get(j), al, visited);
                        if (maxCnt >= 4) { // 터질 예정
                            for (int k=0; k<chainedTmpAl.size(); k++) {
                                willBeDeleted.add(chainedTmpAl.get(k));
                            }
                        }
                    }
                }
            }
            for (int i=0; i<willBeDeleted.size(); i++) {
                Pos p = willBeDeleted.get(i);
            }
            if (willBeDeleted.isEmpty()) {
                break;
            }
            // 터뜨리기 (x가 큰 것부터 터뜨려야 함);
            Collections.sort(willBeDeleted);

            for (int i=0; i<willBeDeleted.size(); i++) {
                Pos p = willBeDeleted.get(i);
                al.get(p.y).remove(p.x);
            }
        }
        System.out.println(answer-1);
    }
    static int maxCnt = 1;
    static ArrayList<Pos> chainedTmpAl = new ArrayList<>();
    private static void isChained (int y, int x, char color, ArrayList<ArrayList<Character>> al, boolean[][] visited) { // 몇 개 붙어있는지 확인
        chainedTmpAl.add(new Pos(y, x));
        visited[y][x] = true;
        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= al.size() || ny < 0 || nx >= al.get(ny).size() || nx < 0) {
                continue;
            }
            if (visited[ny][nx] || al.get(ny).get(nx) != color) {
                continue;
            }
            maxCnt++;
            isChained(ny, nx, color, al, visited);
        }
        return;
    }
}
