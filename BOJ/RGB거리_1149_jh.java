import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int n;
	public static int[][] arr;
	public static int[][] dp;
	public static int dfs(int color, int idx){
		if(dp[idx][color] != Integer.MAX_VALUE)
			return dp[idx][color];
		if(idx >= n) return 0;

		int r = Integer.MAX_VALUE;
		int g = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		if(color == 0){
			g = Math.min(dp[idx][color],arr[idx][color] + dfs(1,idx+1));
			b = Math.min(dp[idx][color],arr[idx][color] + dfs(2,idx+1));
		}
		if(color == 1){
			r = Math.min(dp[idx][color],arr[idx][color] + dfs(0,idx+1));
			b = Math.min(dp[idx][color],arr[idx][color] + dfs(2,idx+1));
		}
		if(color == 2){
			r = Math.min(dp[idx][color],arr[idx][color] + dfs(0,idx+1));
			g = Math.min(dp[idx][color],arr[idx][color] + dfs(1,idx+1));
		}
		int result = Math.min(r,g);
		result = Math.min(result,b);
		return dp[idx][color] = result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[1001][3];
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < 1001; i++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++){
			answer = Math.min(answer,dfs(i,0));
		}
		System.out.println(answer);
	}
}
