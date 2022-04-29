import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int left = 0;
		int right = n - 1;
		int[] result = new int[2];
		int diff = 2000000000;

		while(left<right){
			int sum = arr[left] + arr[right];

			if(Math.abs(sum) < diff){
				result[0] = arr[left];
				result[1] = arr[right];
				diff = Math.abs(sum);
			}

			if(sum > 0){
				right--;
			}
			else{
				left++;
			}
		}
		System.out.println(result[0]+ " " + result[1] + "\n");
	}
}
