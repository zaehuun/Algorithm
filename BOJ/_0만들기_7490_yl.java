import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1시간 40분 - Cheating : O
좋은 문제!
간과한점
1) 배열로 1~7 저장할 필요없음. depth로 구할 수 있다.
2) -, + 는 int로 -1, 1로 표기 가능
*/
public class _0만들기_7490_yl {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++) {
            N = Integer.parseInt(br.readLine());
            dfs (0, 1, 1, "1", 1);
            System.out.println();
        }
    }
    private static void dfs (int sum, int depth, int now, String res, int sign) {
        if (depth == N) {
            sum += (now * sign);
            if (sum == 0) {
                System.out.println(res);
            }
            return;
        }
        dfs(sum, depth+1, now*10+(depth+1), res + ' ' + Integer.toString(depth+1), sign);
        dfs(sum+(sign*now), depth+1, depth+1, res + '+' + Integer.toString(depth+1), 1);
        dfs(sum+(sign*now), depth+1, depth+1, res + '-' + Integer.toString(depth+1), -1);
    }
}
