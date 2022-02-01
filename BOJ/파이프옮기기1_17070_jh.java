import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static int[][] arr;
	public static int n;
	public static class pipe{
		int y;
		int x;
		int type;

		public pipe(int y, int x, int type){
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}
	public static boolean isPossible(pipe p, int type){
		if(type == 0){
			if(p.x + 1 >= n || arr[p.y][p.x+1] == 1) return false;
		}
		else if(type == 1){
			if(p.x + 1 >= n || p.y + 1 >= n || arr[p.y+1][p.x+1] == 1 || arr[p.y][p.x+1] == 1 || arr[p.y+1][p.x] == 1) return false;
		}
		else if(type == 2){
			if(p.y + 1 >= n || arr[p.y+1][p.x] == 1) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(arr[n-1][n-1] == 1){
			System.out.println(0);
			return;
		}
		Queue<pipe> que = new LinkedList<>();
		//0 : 우측, 1 : 대각선, 2 : 아래
		que.offer(new pipe(0,1,0));
		int answer = 0;
		while(!que.isEmpty()){
			pipe p = que.poll();

			if(p.y == n -1 && p.x == n - 1){
				answer++;
				continue;
			}
			//가로
			if(p.type == 0){
				//기로
				if(isPossible(p, 0)){
					que.offer(new pipe(p.y, p.x + 1, 0));
				}
				//대각선
				if(isPossible(p,1)){
					que.offer(new pipe(p.y + 1, p.x + 1, 1));
				}
			}
			else if(p.type == 1){
				if(isPossible(p,0)){
					que.offer(new pipe(p.y, p.x + 1, 0));
				}
				if(isPossible(p,1)){
					que.offer(new pipe(p.y + 1, p.x + 1, 1));
				}
				if(isPossible(p,2)){
					que.offer(new pipe(p.y+1, p.x, 2));
				}
			}
			else if(p.type == 2){
				if(isPossible(p,2)){
					que.offer(new pipe(p.y+1, p.x, 2));
				}
				if(isPossible(p,1)){
					que.offer(new pipe(p.y + 1, p.x + 1, 1));
				}
			}
		}
		System.out.println(answer);

	}
}
