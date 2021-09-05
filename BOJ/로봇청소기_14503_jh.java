import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		int answer = 0;
		int r, c, d;
		String[] s = br.readLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		d = Integer.parseInt(s[2]);

		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		while(true){
			if(arr[r][c] == 0){
				arr[r][c] = 2;
				answer+=1;
			}
			boolean flag = false;
			for(int i = 0; i < 4; i++){
				d = d - 1;
				if(d < 0) d = 3;
				int ty = r + dy[d];
				int tx = c + dx[d];
				if(arr[ty][tx] == 0) {
					r = ty;
					c = tx;
					flag = true;
					break;
				}
			}
			if(flag) continue;
			else{
				r = r - dy[d];
				c = c - dx[d];
				if(arr[r][c] == 1) break;
			}
		}
		System.out.println(answer);

	}
}


