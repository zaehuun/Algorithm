import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int m;
	public static int n;
	public static int[][] arr;
	public static int[][] dp;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static int dfs(int y, int x){
		if(y == m-1 && x == n-1){
			return 1;
		}
		if(dp[y][x] != -1){
			return dp[y][x];
		}
		dp[y][x] = 0;
		for(int i = 0; i < 4; i++){
			int ty = y + dy[i];
			int tx = x + dx[i];

			if(ty < 0 || tx < 0 || ty >= m || tx >= n) continue;
			if(arr[y][x] > arr[ty][tx]){
				dp[y][x] += dfs(ty,tx);
			}
		}
		return dp[y][x];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		dp = new int[m][n];
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0,0));
	}
}
