import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int[][] arr;
	public static int[] dy = {0,0,-1,1};
	public static int[] dx = {1,-1,0,0};
	public static int n;
	public static int m;

	public static boolean isValid(int ny, int nx){
		if(ny < 0 || nx < 0 || ny >= n || nx >= m) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int[] dice = new int[6];
		//head / bottom / left / right / up / down
		Arrays.fill(dice, 0);
		for(int i = 0; i < k; i++){
			int dir = Integer.parseInt(st.nextToken());
			if(!isValid(y + dy[dir - 1],x + dx[dir - 1])) continue;
			if(dir == 1){ //동
				dice = new int[]{dice[2], dice[3],dice[1], dice[0], dice[4], dice[5]};
			}
			else if(dir == 2){ //서
				dice = new int[]{dice[3], dice[2], dice[0], dice[1], dice[4], dice[5]};
			}
			else if(dir == 3){ //북
				dice = new int[]{dice[5], dice[4], dice[2], dice[3], dice[0], dice[1]};
			}
			else if(dir == 4){ //남
				dice = new int[]{dice[4], dice[5], dice[2], dice[3], dice[1], dice[0]};
			}
			y = y + dy[dir - 1];
			x = x + dx[dir - 1];

			if(arr[y][x] == 0){
				arr[y][x] = dice[1];
			}
			else{

				dice[1] = arr[y][x];
				arr[y][x] = 0;
			}
			System.out.println(dice[0]);
		}
	}
}
