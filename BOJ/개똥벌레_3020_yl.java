import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
이해 X
*/
public class 개똥벌레_3020_yl {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken()); // 장애물의 크기는 H보다 작은 양수

        int[] top = new int[H+1];
        int[] bottom = new int[H+1];
        for (int i=0; i<N/2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        int[] top_sum = new int[H+1];
        int[] bottom_sum = new int[H+1];
        // 누적합 계산
        for (int i=1; i<=H; i++) {
            bottom_sum[i] = bottom_sum[i-1] + bottom[i];
            top_sum[i] = top_sum[i-1] + top[i];
        }

        int min = N;
        int cnt = 0;
        for (int i=1; i<=H; i++) {
            int crush = 0; // 부딪히는 개수
            crush += bottom_sum[H] - bottom_sum[i-1]; // bottom 부딪히는 개수 = 전체 - (i-1) 이하의 bottom 개수
            crush += top_sum[H] - top_sum[H-i]; // top 부딪히는 개수 = 전체 - (h-i) 이하의 top 개수

            if (min > crush) {
                min = crush;
                cnt = 1;
            }
            else if (min == crush) {
                cnt++;
            }
        }
        System.out.println(min+" "+cnt);
        for (int item : bottom_sum) {
            System.out.print(item+" ");
        }
        System.out.println();
        for (int item : top_sum) {
            System.out.print(item+" ");
        }
    }
}
