import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int n;
	public static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				arr[i][j] = i == j ? 0 : Integer.MAX_VALUE;
		}
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(arr[i][j] > arr[i][k] + arr[k][j]){
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken());
			if(arr[start][end] <= time) System.out.println("Enjoy other party");
			else System.out.println("Stay here");
		}
	}
}
