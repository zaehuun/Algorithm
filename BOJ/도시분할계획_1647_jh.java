import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] parent;
	public static int n;
	public static int m;
	public static class node implements Comparable<node>{
		int start;
		int end;
		int weight;
		public node(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(node n){
			return this.weight - n.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		List<node> list = new ArrayList<>();

		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			list.add(new node(start, end ,weight));
		}
		int answer = 0;
		int cost = 0;
		Collections.sort(list);
		parent = new int[n+1];
		for(int i = 1; i <= n; i++){
			parent[i] = i;
		}
		for(int i = 0; i < list.size(); i++){
			node n = list.get(i);
			if(find(n.start) != find(n.end)){
				answer += n.weight;
				cost = n.weight;
				union(n.start, n.end);
			}
		}

		for(int i = 1; i <= n; i++){
			System.out.println(parent[i]);
		}
		System.out.println(answer - cost);
	}

	public static void union(int x, int y){
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot != yRoot) parent[yRoot] = xRoot;
	}

	public static int find(int x){
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}
}
