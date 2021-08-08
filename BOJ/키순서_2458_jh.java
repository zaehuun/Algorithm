import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		int[][] arr = new int[n][n];

		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			arr[start][end] = 1;
			arr[end][start] = -1;
		}
		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++){
					if(arr[i][k] == 0) continue;
					if(arr[k][j] == 0) continue;
					if(arr[i][k] == arr[k][j]){
						arr[i][j] = arr[i][k];
						arr[j][i] = arr[i][j] * -1;
					}
				}
		for(int i = 0; i < n; i++){
			int cnt = 0;
			for(int j = 0; j < n; j++){
				if(arr[i][j] == 0)
					cnt++;
			}
			if(cnt == 1)
				answer++;
		}
		System.out.println(answer);
	}

}
