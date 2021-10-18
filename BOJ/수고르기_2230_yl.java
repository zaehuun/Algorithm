import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
10분 - Cheating : X
*/
public class 수고르기_2230_yl {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int startIdx = 0;
        int endIdx = 0;
        int minDiff = Integer.MAX_VALUE;
        while (startIdx < N && endIdx < N) {
            int diff = Math.abs(arr[endIdx] - arr[startIdx]);
            if (diff < M) {
                endIdx++;
            }
            else {
                minDiff = Math.min(minDiff, diff);
                startIdx++;
            }
        }
        System.out.println(minDiff);
    }
}
