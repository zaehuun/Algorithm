import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] arr;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,1,-1};
	public static class Node{
		int y;
		int x;
		public Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static int find(int y, int x){
		int count = 0;
		for(int i = 0; i < 4; i++){
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty < 0 || tx < 0 || ty >= arr.length || tx >= arr[0].length) continue;
			if(arr[ty][tx] == 0) count++;
		}
		return count;
	}
	public static void bfs(int y, int x, boolean[][] visit, int[][] copy){
		visit[y][x] = true;
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(y,x));

		while(!que.isEmpty()){
			Node node = que.poll();
			for(int i = 0; i < 4; i++){
				int ty = node.y + dy[i];
				int tx = node.x + dx[i];
				if(ty < 0 || tx < 0 || ty >= arr.length || tx >= arr[0].length) continue;
				if(copy[ty][tx] == 0) continue;
				if(visit[ty][tx]) continue;
				visit[ty][tx] = true;
				que.offer(new Node(ty,tx));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 1;
		while(true){
			int[][] copy = new int[n][m];
			boolean[][] visit = new boolean[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					copy[i][j] = arr[i][j];
					visit[i][j] = false;
					if(arr[i][j] != 0){
						copy[i][j] = copy[i][j] - find(i,j);
						if(copy[i][j] < 0) copy[i][j] = 0;
					}
				}
			}
			int count = 0;
			boolean flag = true;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					if(copy[i][j] > 0 && !visit[i][j]){
						bfs(i,j,visit, copy);
						count++;
						flag = false;

					}
				}
			}

			if(count >= 2){
				System.out.println(answer);
				return;
			}
			else{
				if(flag){
					System.out.println("엥");
					return;
				}
				else{
					for(int i = 0; i < n; i++){
						for(int j = 0; j < m; j++){
							arr[i][j] = copy[i][j];
						}
					}
					answer++;
				}
			}
		}
	}
}

