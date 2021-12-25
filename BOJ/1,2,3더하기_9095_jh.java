import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int n;
	public static int[] arr;
	public static int dfs(int pos){
		if(arr[pos] != Integer.MAX_VALUE)
			return arr[pos];
		if(pos == 0) return 1;
		if(pos == 1) return 1;
		if(pos == 2) return 2;
		if(pos == 3) return 4;

		arr[pos] = dfs(pos-1) + dfs(pos-2) + dfs(pos-3);

		return arr[pos];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[12];

		Arrays.fill(arr, Integer.MAX_VALUE);

		for(int i = 0; i < n; i++) {
			int v = Integer.parseInt(br.readLine());
			System.out.println(dfs(v));
		}
	}
}
