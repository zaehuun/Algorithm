import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		int[] dp = new int[k+1];
		for(int i = 0; i < n; i++){
			coins[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		for(int coin = 0; coin < n; coin++){
			for(int count = 0; count <= k; count++){
				if(count - coins[coin] >= 0)
					dp[count] += dp[count - coins[coin]];
			}
		}
		System.out.println(dp[k]);
	}
}
