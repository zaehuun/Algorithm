import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		while(end <= N){
			int sum = 0;
			for(int i = start; i < end; i++)
				sum += arr[i];
			if(sum == M) answer++;
			if(sum >= M) start++;
			else end++;
		}
		System.out.println(answer);
	}
}
