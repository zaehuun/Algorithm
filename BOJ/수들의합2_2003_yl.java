import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
10분 - Cheating : X
*/
public class 수들의합2_2003_yl {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int answer = 0;
        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        while (endIdx < arr.length) {
            if (sum + arr[endIdx] > m) {
                sum -= arr[startIdx];
                startIdx++;
            }
            else if (sum + arr[endIdx] < m) {
                sum += arr[endIdx];
                endIdx++;
            }
            else if (sum + arr[endIdx] == m) {
                sum += arr[endIdx];
                sum -= arr[startIdx];
                answer++;
                startIdx++;
                endIdx++;
            }
        }
        System.out.println(answer);
    }
}
