import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static List<Integer>[] list;
	public static int answer = 0;
	public static void dfs(int idx, int target){
		if(idx == target) return;

		if(list[idx].size() == 0){
			answer++;
			return;
		}
		for(int i : list[idx]){
			if(list[idx].size() == 1 && i == target){
				answer++;
				return;
			}
			dfs(i,target);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for(int i = 0; i < N; i++){
			list[i] = new ArrayList<>();
		}
		int root = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int node = Integer.parseInt(st.nextToken());
			if(node == -1) {root = i; continue;}
			list[node].add(i);
		}

		int target = Integer.parseInt(br.readLine());
		dfs(root,target);
		System.out.println(answer);


	}
}


