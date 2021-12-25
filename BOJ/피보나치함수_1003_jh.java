import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int n;
	public static int[][] arr;
	public static void dfs(int pos){
		if(arr[pos][0] != Integer.MAX_VALUE && arr[pos][1] != Integer.MAX_VALUE){
			return;
		}
		if(pos == 0){
			arr[pos][0] = 1;
			arr[pos][1] = 0;
			return;
		}
		if(pos == 1){
			arr[pos][0] = 0;
			arr[pos][1] = 1;
			return;
		}

		dfs(pos-1);
		dfs(pos-2);

		arr[pos][0] = arr[pos-1][0] + arr[pos-2][0];
		arr[pos][1] = arr[pos-1][1] + arr[pos-2][1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[41][2];
		for(int i = 0; i < 41; i++){
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}

		for(int i = 0; i < n; i++) {
			int v = Integer.parseInt(br.readLine());
			dfs(v);
			System.out.println(arr[v][0] + " " + arr[v][1]);
		}
	}
}
