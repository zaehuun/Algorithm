//LCA 알고리즘을 공부해봤다.
//가장 먼저 풀이 방법이 생각난게 이거라...
//근데 풀이법을 검색해보니 dfs 두 번 돌려서 풀던데
//내 스타일은 아니었다.
//dfs 두 번 풀이는 수학적으로 증명해야 되는데 사람들이 다들 어떻게 그 방법을 알고 푼걸까...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static List<Integer>[] tree;
	public static boolean[] isNotLeaf;
	public static int[] cost;
	public static int[] depth;
	public static int[] parent;
	public static void dfs(int idx, int d){
		depth[idx] = d;
		for(int i : tree[idx]){
			if(depth[i] == 0){
				dfs(i, d + 1);
				parent[i] = idx;
			}
		}
	}
	public static int lca(int a, int b){
		int sum = 0;


		while(depth[a] > depth[b]){
			sum += cost[a];
			a = parent[a];
		}

		while(depth[a] < depth[b]){
			sum += cost[b];
			b = parent[b];
		}

		while(a != b){
			sum += cost[b];
			sum += cost[a];
			a = parent[a];
			b = parent[b];
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());


		tree = new ArrayList[n+1];
		isNotLeaf = new boolean[n+1];
		cost = new int[n+1];
		depth = new int[n+1];
		parent = new int[n+1];

		for(int i = 1; i <= n; i++)
			tree[i] = new ArrayList<>();

		for(int i = 0; i < n - 1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			isNotLeaf[parent] = true;
			tree[parent].add(child);
			cost[child] = c;
		}
		dfs(1, 1);

		List<Integer> leaf = new ArrayList<>();
		leaf.add(1);
		for(int i = 1; i <= n; i++){
			if(!isNotLeaf[i])
				leaf.add(i);
		}

		int answer = 0;
		for(int i = 0; i < leaf.size() - 1; i++){
			for(int j = i + 1; j < leaf.size(); j++){
				answer = Math.max(answer, lca(leaf.get(i), leaf.get(j)));
			}
		}
		System.out.println(answer);
	}
}
