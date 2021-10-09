import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,-1,0,1};
	public static int shark = 2;
	public static int sy = -1;
	public static int sx = -1;
	public static int[][] arr;
	public static int N;
	public static int time;
	static class node{
		int y;
		int x;
		int time;
		public node(int y, int x, int time){
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	public static int[] bfs(){
		boolean[][] visit = new boolean[N][N];
		Queue<node> que = new LinkedList<>();
		que.offer(new node(sy,sx, 0));
		visit[sy][sx] = true;
		int resultY = 999;
		int resultX = 999;
		int resultTime = 999;
		while(!que.isEmpty()){
			node n = que.poll();
			int y = n.y;
			int x = n.x;
			int time = n.time;
//			System.out.println(y + " " + x + " " + time);
			for(int i = 0; i < 4; i++){
				int ty = y + dy[i];
				int tx = x + dx[i];
//				System.out.println(ty+ " " +tx);
				if(ty < 0 || ty >= N || tx < 0 || tx >= N) continue;
				if(visit[ty][tx]) continue;
				if(arr[ty][tx] > shark) continue;

				visit[ty][tx] = true;
				if(arr[ty][tx] < shark && arr[ty][tx] != 0){
					if (time + 1 < resultTime) {
						resultTime = time + 1;
						resultY = ty;
						resultX = tx;
					}
					else if(time + 1 == resultTime){
						if(ty < resultY){
							resultTime = time + 1;
							resultY = ty;
							resultX = tx;
						}
						else if( ty == resultY){
							if(tx < resultX){
								resultTime = time + 1;
								resultY = ty;
								resultX = tx;
							}

						}
					}
				}
				que.offer(new node(ty,tx,time+1));
			}
		}
		return new int[]{resultY, resultX, resultTime};
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9){
					sy = i;
					sx = j;
					arr[i][j] = 0;
				}
			}
		}
		int cnt = 0;
		while(true){
			int[] result = bfs();
			if(result[0] == 999) break;
			sy = result[0];
			sx = result[1];
			time += result[2];
			arr[sy][sx] = 0;
			cnt++;
			if(cnt == shark){
				cnt = 0;
				shark++;
			}
		}

		System.out.println(time);

	}
}


