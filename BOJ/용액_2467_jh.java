import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = n - 1;
		int answer = Integer.MAX_VALUE;

		int lIdx = -1;
		int rIdx = -1;
		while(left<right){
			int lV = arr[left];
			int rV = arr[right];
			int diff = lV+rV;
			if(answer >= Math.abs(diff)){
				lIdx = left;
				rIdx = right;
				answer = Math.abs(diff);
			}

			if(diff >= 0) right--;
			else left++;
		}
		System.out.println(arr[lIdx] + " " + arr[rIdx]);
	}
}


