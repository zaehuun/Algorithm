//다시 코테 준비를 시작해야 할 거 같다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static List[] list;
	public static boolean[] visit;
	public static int answer = 0;
	public static void dfs(int idx){
		visit[idx] = true;
		for(int i = 0; i < list[idx].size(); i++){
			if(!visit[(int) list[idx].get(i)]){
				answer++;
				dfs((int) list[idx].get(i));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++)
			list[i] = new ArrayList<Integer>();
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start= Integer.parseInt(st.nextToken()) -1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			list[start].add(end);
			list[end].add(start);
		}
		dfs(0);
		System.out.println(answer);
	}
}
