import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static int n;
	public static int l;
	public static int r;
	public static boolean find;
	public static int[][] visit;
	public static int[][] arr;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static class Node{
		int y;
		int x;
		int v;
		public Node(int y, int x, int v){
			this.y = y;
			this.x = x;
			this.v = v;
		}
	}

	public static void bfs(int y, int x, int group){
		visit[y][x] = group;
		Queue<Node> que = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		que.offer(new Node(y,x, arr[y][x]));

		int sum = 0;
		while(!que.isEmpty()){
			Node no = que.poll();
			list.add(no);
			sum += no.v;
			for(int i = 0; i < 4; i++){
				int ty = no.y + dy[i];
				int tx = no.x + dx[i];

				if(ty < 0 || tx < 0 || ty >= n || tx >= n) continue;
				if(visit[ty][tx] != 0) continue;

				int diff = Math.abs(arr[no.y][no.x] - arr[ty][tx]);
				if(diff < l) continue;
				if(diff > r) continue;

				visit[ty][tx] = group;
				que.offer(new Node(ty,tx, arr[ty][tx]));
			}
		}
		if(list.size() <= 1){
			return;
		}
		find = true;
		int avg = (int)Math.floor((double)sum / list.size());
		for(Node no : list){
			arr[no.y][no.x] = avg;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while(true){
			visit = new int[n][n];
			int group = 1;

			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(visit[i][j] == 0){
						bfs(i,j,group);
						group++;
					}
				}
			}
			if(!find) break;
			find = false;
			answer++;
		}
		System.out.println(answer);
	}
}
