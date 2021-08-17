import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static char[][] arr = new char[21][21];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max = 1;
	public static void dfs(int y, int x, Set<Character> set, int row, int col){
		if(set.size() > max) max = set.size();
		for(int i = 0; i < 4; i++) {
			int ty = y + dy[i];
			int tx = x + dx[i];
			if (ty < 0 || ty >= row || tx < 0 || tx >= col) continue;
			if (set.contains(arr[ty][tx])) continue;
			set.add(arr[ty][tx]);
			dfs(ty, tx, set, row, col);
			set.remove(arr[ty][tx]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for(int i = 0; i < R; i++){
			String row = br.readLine();
			for(int j = 0; j < C; j++){
				arr[i][j] = row.charAt(j);
			}
		}
		Set<Character> set = new HashSet<>();
		set.add(arr[0][0]);
		dfs(0,0,set,R,C);

		System.out.println(max);
	}

}
