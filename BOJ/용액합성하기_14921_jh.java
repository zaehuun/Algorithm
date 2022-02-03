import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = n - 1;
		int answer = Integer.MAX_VALUE;
		while(left<right){
			int mid = arr[left] + arr[right];

			if(Math.abs(mid) < Math.abs(answer)){
				answer = mid;
			}
			if(mid > 0){
				right--;
			}
			else left++;
		}
		System.out.println(answer);
	}
}
