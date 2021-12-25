import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int n;
	public static int[] arr;
	public static int dfs(int pos){
		if(pos < 1) return Integer.MAX_VALUE;
		if(arr[pos] != Integer.MAX_VALUE){
			return arr[pos];
		}
		if(pos == 1){
			return arr[pos] = 0;
		}
		if(pos % 3 == 0)
			arr[pos] = Math.min(arr[pos], dfs(pos/3) + 1);
		if(pos % 2 == 0)
			arr[pos] = Math.min(arr[pos], dfs(pos/2) + 1);
		arr[pos] = Math.min(arr[pos], dfs(pos-1) + 1);
		return arr[pos];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[1000001];
		Arrays.fill(arr, Integer.MAX_VALUE);
		int result = dfs(n);
		System.out.println(result);
	}
}
