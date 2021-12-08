import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int[][] visit;
	public static int n;
	public static int m;
	public static int answer = 0;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,1,-1};
	public static class node{
		int y;
		int x;
		int dis;
		int pop;
		public node(int y, int x, int dis, int pop){
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.pop = pop;
		}
	}
	public static int bfs(int y, int x){
		Queue<node> que = new LinkedList<>();
		que.offer(new node(y,x,1,0));
		visit[y][x] = 0;

		while(!que.isEmpty()){
			node target = que.poll();
			if(target.y == n - 1 && target.x == m - 1){
				return target.dis;
			}
			for(int i = 0; i < 4; i++){
				int ty = target.y + dy[i];
				int tx = target.x + dx[i];

				if(ty < 0 || tx < 0 || ty >= n || tx >= m) continue;
				if(visit[ty][tx] > target.pop){
					if(arr[ty][tx] == 0){
						que.offer(new node(ty,tx,target.dis+1, target.pop));
						visit[ty][tx] = target.pop;
					}
					else{
						if(target.pop == 0){
							que.offer(new node(ty,tx,target.dis+1, target.pop+1));
							visit[ty][tx] = target.pop + 1;
						}

					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new int[n][m];
		for(int i = 0; i < n; i++){
			String s = br.readLine();
			for(int j = 0; j < m; j++){
				arr[i][j] = s.charAt(j) - '0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		System.out.println(bfs(0,0));
	}
}
