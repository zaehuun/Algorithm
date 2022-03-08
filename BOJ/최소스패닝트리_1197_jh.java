import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int[] parents;
	public static class node implements Comparable<node>{
		int st;
		int end;
		int v;

		public node(int st, int end, int v){
			this.st= st;
			this.end = end;
			this.v = v;
		}

		@Override
		public int compareTo(node o) {
			return this.v < o.v ? -1 : 1;
		}
	}
	public static int find(int t){
		if(parents[t] == t) return t;
		parents[t] = find(parents[t]);
		return parents[t];
	}

	public static void union(int x, int y){
		int px = find(x);
		int py = find(y);
		if(px != py) parents[py] = px;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<node> list = new ArrayList<>();

		parents = new int[n+1];
		for(int i = 1; i <= n; i++){
			parents[i] = i;
		}
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new node(start, end, v));
		}
		Collections.sort(list);
		int answer = 0;
		for(node no : list){
			if(find(no.st) != find(no.end)){
				answer += no.v;
				union(no.st, no.end);
			}
		}
		System.out.println(answer);

	}
}
