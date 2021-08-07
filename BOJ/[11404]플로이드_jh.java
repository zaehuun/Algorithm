import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
			Arrays.fill(arr[i], 987654321);
		for(int i = 0; i < m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[start-1][end-1] = Math.min(arr[start-1][end-1],cost);
		}

		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++){
					if(i == j) continue;
					if(arr[i][j] > arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j];
				}
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(arr[i][j] == 987654321 ? "0 " : arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
