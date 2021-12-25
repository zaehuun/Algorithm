import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int n;
	public static int[] arr;
	public static int dfs(int pos, int count){
		if(pos < 0) return Integer.MAX_VALUE;
		if(arr[pos] != Integer.MAX_VALUE){
			return arr[pos];
		}
		if(pos == 0){
			return count;
		}
		arr[pos] = Math.min(arr[pos], dfs(pos-5, count+1));
		arr[pos] = Math.min(arr[pos], dfs(pos-3, count+1));
		return arr[pos];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[5001];
		Arrays.fill(arr, Integer.MAX_VALUE);
		int result = dfs(n,0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}
