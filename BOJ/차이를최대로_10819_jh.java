import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static int n;
	public static int[] arr;
	public static boolean[] visit;
	public static int answer = Integer.MIN_VALUE;
	public static void bfs(String st, int cnt){
		if(cnt == n){
			String[] parse = st.split(",");
			int temp = 0;
			for(int i = 1; i < parse.length; i++){
				temp += Math.abs(Integer.parseInt(parse[i-1]) - Integer.parseInt(parse[i]));
			}
			answer = Math.max(answer, temp);
			return;
		}
		for(int i = 0; i < n; i++){
			if(visit[i]) continue;
			visit[i] = true;
			bfs(st + arr[i] + ",", cnt + 1);
			visit[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bfs("",0);

		System.out.println(answer);
	}
}
