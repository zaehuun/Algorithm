//각 집을 기준으로 모든 치킨 집까지의 치킨 거리를 구하고 계산하는 문제인줄 알았는데 아니었다.
//문제가 참 설명이 이상한건가..
//암튼 아래 코드는 이상하게 이해하고 푼 문제다.
public class Main {
	public static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static int bfs(Pos pos, int N, int[][] arr){
		int chickenY = pos.y;
		int chickenX = pos.x;
		boolean[][] visit = new boolean[N][N];
		visit[chickenY][chickenX] = true;
		Queue<Pos> que = new LinkedList<>();
		que.offer(pos);
		int chickenDistance = 0;
		System.out.println();
		while(!que.isEmpty()){
			Pos p = que.poll();
			if(arr[p.y][p.x] == 1){
				chickenDistance += Math.abs(p.y-chickenY) + Math.abs(p.x-chickenX);
			}

			for(int i = 0; i < 4; i++){
				int y = dy[i] + p.y;
				int x = dx[i] + p.x;
				if(y < 0 || y >= N || x < 0 || x >= N) continue;
				if(visit[y][x]) continue;
				visit[y][x] = true;
				que.offer(new Pos(y,x));
			}
		}
		return chickenDistance;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];

		List<Pos> chicken = new ArrayList<>();

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				arr[i][j] = v;
				if(v == 2) chicken.add(new Pos(i,j));
			}
		}
		List<Integer> answer = new ArrayList<>();
		for(Pos p : chicken)
			answer.add(bfs(p,N,arr));
		Collections.sort(answer);
		System.out.println(answer);
		int result = 0;
		for(int i = 0; i < M; i++)
			result += answer.get(i);
		System.out.println(result);
	}
}
//여기부터 제대로 이해하고 푸는건데 졸려서 완성안했다 아직..
//자바에는 없는 순열과 조합을 직접 구현하고 있는데 뭔가 생각보다 재밌다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static List<Pos> house = new ArrayList<>();
	static List<Pos> chicken = new ArrayList<>();
	static List<List<Pos>> comb = new ArrayList<>();
	public static void combination(int idx, int M, List<Pos> pos){

		if(pos.size()== M){
//			System.out.println(pos.get(0).y);
//			System.out.println(pos.get(1).y);
//			System.out.println(pos.get(2).y);
			List<Pos> list = new ArrayList<>();
			for(int i = 0; i < pos.size(); i++)
				list.add(new Pos(pos.get(i).y, pos.get(i).x));
			comb.add(list);
		}
		else{
			for(int i = idx; i < chicken.size(); i++){
				pos.add(chicken.get(i));
				combination(i+1,M,pos);
				pos.remove(pos.size()-1);
			}

		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v == 2) chicken.add(new Pos(i,j));
				if(v == 1) house.add(new Pos(i,j));
			}
		}
		combination(0, M,new ArrayList<Pos>());
		


	}
}


