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

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		List<node> list = new ArrayList<>();
		for(int i = 0; i < m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new node(start, end, weight));
		}

		Collections.sort(list);
		parent = new int[n+1];
		for(int i = 1; i <= n; i++){
			parent[i] = i;
		}
		int answer = 0;
		for(int i = 0; i < list.size(); i++){
			node n = list.get(i);
			if(find(n.start) != find(n.end)){
				answer += n.weight;
				union(n.start, n.end);
			}
		}

		System.out.println(answer);
	}

	public static void union(int st, int end){
		int stRoot = find(st);
		int endRoot = find(end);
		if(stRoot != endRoot) parent[endRoot] = stRoot;
	}
	public static int find(int t){
		if(parent[t] == t) return t;
		return parent[t] = find(parent[t]);
	}
}
