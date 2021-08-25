import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
1시간 10분 - Cheating : X
이거슨 좋은문제다..! 투포인터 문제로 충분히 나올 수 있음
while문 탈출조건 만드는데 오래걸렸음
*/
public class 부분합_1806_yl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개수
        int S = Integer.parseInt(st.nextToken()); // 합이 S 이상인 것

        int[] arr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int sum = 0;
        int startIdx = 0;
        int endIdx = 0;
        ArrayList<Integer> ansAl = new ArrayList<>();
        while (true) {
            if (startIdx == arr.length) {
                break;
            }
            if (sum >= S) {
                System.out.println("답 = "+startIdx+" "+endIdx+" sum = "+sum);
                ansAl.add(endIdx - startIdx);
                sum -= arr[startIdx];
                startIdx++;
            }
            else if (sum < S) {
                if (endIdx >= arr.length) { // endIdx가 맨 끝인데 S보다 작으면 startIdx가 ++여도 S 이상일 수 없으니까 break
                    break;
                }
                sum += arr[endIdx];
                endIdx++;
            }
        }
        if (ansAl.size() == 0) {
            System.out.println(0);
            return;
        }
        Collections.sort(ansAl);
        System.out.println(ansAl.get(0));

    }
}
