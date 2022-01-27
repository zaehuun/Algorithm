import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static class Node{
		int y;
		int x;
		public Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static void bfs(int i, int j, int row, int col){
		visit[i][j] = true;
		arr[i][j] = 2;
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(i,j));

		while(!que.isEmpty()){
			Node n = que.poll();

			for(int idx = 0; idx < 4; idx++){
				int ty = n.y + dy[idx];
				int tx = n.x + dx[idx];

				if(ty < 0 || tx < 0 || ty >= row || tx >= col) continue;
				if(arr[ty][tx] == 1) continue;
				if(visit[ty][tx]) continue;

				visit[ty][tx] = true;
				arr[ty][tx] = 2;
				que.offer(new Node(ty,tx));
			}
		}

	}

	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,1,-1};
	public static boolean[][] visit;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;

		while(true){
			boolean flag = false;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					visit[i][j] = false;
				}
			}
//			visit = new boolean[n][m];
			bfs(0,0,n,m);

			List<Node> li = new ArrayList<>();
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					if(arr[i][j] == 1){
						flag = true;
						int count = 0;
						for(int k = 0; k < 4; k++){
							int ty = i + dy[k];
							int tx = j + dx[k];
							if(ty < 0 || tx < 0 || ty >= n || tx >= m) continue;

							if(arr[ty][tx] == 2) count++;
						}
						if(count >= 2) li.add(new Node(i,j));
					}
				}
			}
			if(!flag) break;
			for(Node no : li){
				arr[no.y][no.x] = 0;
			}
			answer++;
		}
		System.out.println(answer);
	}
}
