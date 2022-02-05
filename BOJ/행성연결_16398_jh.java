import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int[] parents;

	public static class Planet implements Comparable<Planet>{
		int start;
		int end;
		int weight;
		public Planet(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Planet o) {
			return this.weight - o.weight;
		}
	}
	public static int find(int x){
		if(parents[x] == x) return x;
		parents[x] = find(parents[x]);
		return parents[x];
	}
	public static void union(int x, int y){
		int xp = find(x);
		int yp = find(y);
		if(xp != yp) parents[yp] = xp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		parents = new int[n];
		PriorityQueue<Planet> pq = new PriorityQueue<>();

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				int weight = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				pq.add(new Planet(i,j,weight));
			}
		}
		for(int i = 0; i < n; i++){
			parents[i] = i;
		}
		long answer = 0;
		while(!pq.isEmpty()){
			Planet p = pq.poll();
			if(find(p.start) != find(p.end)){
				answer += p.weight;
				union(p.start, p.end);
			}
		}
		System.out.println(answer);
	}
}
