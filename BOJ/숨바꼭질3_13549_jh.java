import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static class Pos{
		int pos;
		int time;

		public Pos(int pos, int time){
			this.pos = pos;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[100001];

		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(n,0));
		visit[n] = true;
		int answer = Integer.MAX_VALUE;
		while(!que.isEmpty()){
			Pos p = que.poll();

			int v = p.pos;
			int time = p.time;
			visit[v] = true;
			if(v == k) {
				answer = Math.min(answer, time);
			}

			if(v + 1 <= 100000 && !visit[v+1]){
				que.offer(new Pos(v + 1, time + 1));
//				visit[v+1] =
			}
			if(v - 1 >= 0 && !visit[v-1]){
				que.offer(new Pos(v - 1, time + 1));
			}
			if(v * 2 <= 100000 && !visit[v*2]){
				que.offer(new Pos(v * 2, time + 0));
			}
		}
		System.out.println(answer);
	}
}
