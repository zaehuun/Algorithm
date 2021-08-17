import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0;
	static int[][] arr = new int[26][26];
	static boolean[][] visit = new boolean[26][26];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void dfs(int y, int x, int N, int num){
		visit[y][x] = true;
		arr[y][x] = num;
		for(int i = 0; i < 4; i++){
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(tx >= N || tx < 0 || ty >= N || ty < 0) continue;
			if(visit[ty][tx]) continue;
			if(arr[ty][tx] == 0) continue;
			dfs(ty,tx,N,num);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++){
			String row = br.readLine();
			for(int j = 0; j < row.length(); j++){
				arr[i][j] = row.charAt(j) - '0';
			}
		}

		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(visit[i][j] == false && arr[i][j] == 1){
					dfs(i,j,N,++cnt);
				}
			}
		}
		int[] answer = new int[cnt];
		
		for(int c = 1; c <= cnt; c++){
			int t = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(arr[i][j] == c) t++;
				}
			}
			answer[c-1] = t;
		}
		Arrays.sort(answer);
		System.out.println(cnt);
		for(int i : answer)
			System.out.println(i);
	}

}
