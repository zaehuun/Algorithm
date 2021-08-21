import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[N+1];
		for(int i = 2; i*i <= N; i++){
			if(!isPrime[i]){
				for(int j = i * i; j <= N; j+=i)
					isPrime[j] = true;
			}
		}
		List<Integer> arr = new ArrayList<>();
		for(int i = 2; i <= N; i++)
			if(!isPrime[i])
				arr.add(i);

		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = 0;
		while(true){
			if(sum >= N){
				sum -= arr.get(start);
				start++;
			}
			else if(end == arr.size()) break;
			else{
				sum += arr.get(end);
				end++;
			}
			if(sum == N) answer++;
		}
		System.out.println(answer);
	}
}
