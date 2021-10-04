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
		int[] arr = new int[N];

		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());


		Arrays.sort(arr);
		int left = 0, right = 0;
		int min = 2000000000;
		while(left < N && right < N){
			int v = arr[right] - arr[left];
			if(v < M) right++;
			else{
				left++;
				min = Math.min(min, v);
			}
		}
		System.out.println(min);
	}
}


