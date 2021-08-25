import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
20분 - Cheating : O (에라토스테네스의 체)
*/
public class 소수의연속합_1644_yl {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] notPrime = new boolean[N+1];
        notPrime[0] = notPrime[1] = true;
        // 에라토스테네스의 체
        for (int i=2; i*i<=N; i++) {
            if (!notPrime[i]) {
                for (int j=i*i; j<=N; j+=i) {
                    notPrime[j] = true;
                }
            }
        }
        // 소수 ArrayList 생성
        ArrayList<Integer> primeNums = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            if (!notPrime[i]) {
                primeNums.add(i);
            }
        }
        int answer = 0;
        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        while (endIdx < primeNums.size()) {
            if (sum < N) {
                sum += primeNums.get(endIdx);
                endIdx++;
            }
            else if (sum > N) {
                sum -= primeNums.get(startIdx);
                startIdx++;
            }
            else if (sum == N) {
                answer++;
                sum -= primeNums.get(startIdx);
                sum += primeNums.get(endIdx);
                startIdx++;
                endIdx++;
            }
        }
        if (primeNums.contains(N)) {
            answer += 1;
        }
        System.out.println("Answer = "+answer);


    }
}
