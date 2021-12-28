import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int n;
	public static int[][] arr;
	public static int[][] dp;
	public static int dfs(int row, int idx){
		if(dp[row][idx] != Integer.MIN_VALUE)
			return dp[row][idx];
		if(row >= n) return 0;
		dp[row][idx] = Math.max(dfs(row+1,idx), dfs(row+1,idx+1)) + arr[row][idx];

		return dp[row][idx];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[501][501];
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++){
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		System.out.println(dfs(0,0));
	}
}
