import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int n;
	public static int m;
	public static int answer = 0;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,1,-1};
	public static class node{
		int y;
		int x;
		public node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static List<node> virus = new ArrayList<>();
	public static int bfs(){
		Queue<node> que = new LinkedList<>(virus);
		int[][] tmp = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				tmp[i][j] = arr[i][j];
			}
		}
		while(que.size() != 0){
			node q = que.poll();
			for(int i = 0; i < 4; i++){
				int ty = q.y + dy[i];
				int tx = q.x + dx[i];

				if(ty < 0 || tx < 0 || ty >= n || tx >= m) continue;
				if(tmp[ty][tx] == 1 || tmp[ty][tx] == 2) continue;

				tmp[ty][tx] = 2;
				que.offer(new node(ty,tx));
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(tmp[i][j] == 0) count++;
			}
		}
		return count;
	}
	public static void setWalls(int wall){
		if(wall == 3){
			answer = Math.max(answer, bfs());
			return;
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(arr[i][j] == 0){
					arr[i][j] = 1;
					setWalls(wall+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2){
					virus.add(new node(i,j));
				}
			}

		}
		setWalls(0);
		System.out.println(answer);
	}
}
