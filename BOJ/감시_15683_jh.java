import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static List<Cctv> cctv = new ArrayList<>();
	public static boolean[][] check;
	public static int[][] arr;
	public static int answer = Integer.MAX_VALUE;
	public static class Cctv{
		int y;
		int x;
		int dir;
		public Cctv(int y, int x, int dir){
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
	public static void checkArea(int[][] map){
		int count = 0;
		int n = arr.length;
		int m = arr[0].length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map[i][j] == 0) count++;
			}
		}
		answer = Math.min(answer, count);
	}

	public static int[][] draw(int y, int x, String dirs, int[][] origin){
		char[] dir = dirs.toCharArray();
		int[][] copy = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++)
				copy[i][j] = origin[i][j];
		}

		for(char c : dir) {
			if (c == 'U') {
				for(int ty = y; ty >= 0; ty--){
					if(copy[ty][x] == 6) break;
					if(copy[ty][x] == 0)
						copy[ty][x] = 999;
				}
			} else if (c == 'R') {
				for(int tx = x; tx < arr[0].length; tx++){
					if(copy[y][tx] == 6) break;
					if(copy[y][tx] == 0)
						copy[y][tx] = 999;
				}
			} else if (c == 'D') {
				for(int ty = y; ty < arr.length; ty++){
					if(copy[ty][x] == 6) break;
					if(copy[ty][x] == 0)
						copy[ty][x] = 999;
				}
			} else if (c == 'L') {
				for(int tx = x; tx >= 0; tx--){
					if(copy[y][tx] == 6) break;
					if(copy[y][tx] == 0)
						copy[y][tx] = 999;
				}
			}
		}
		return copy;
	}
	public static void dfs(int idx, int[][] map){
		if(idx == cctv.size()){
			checkArea(map);
			return;
		}
		for(int i = idx; i < cctv.size(); i++){
			Cctv c = cctv.get(i);
			int[][] copy;
			if(c.dir == 1){
				copy = draw(c.y, c.x, "U", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "R", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "D", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "L", map);
				dfs(i + 1, copy);
			}
			else if(c.dir == 2){
				copy = draw(c.y, c.x, "UD", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "RL", map);
				dfs(i + 1, copy);
			}
			else if(c.dir == 3){
				copy = draw(c.y, c.x, "UR", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "RD", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "DL", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "UL", map);
				dfs(i + 1, copy);
			}
			else if(c.dir == 4){
				copy = draw(c.y, c.x, "URD", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "RDL", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "DLU", map);
				dfs(i + 1, copy);

				copy = draw(c.y, c.x, "LUR", map);
				dfs(i + 1, copy);
			}
			else if(c.dir == 5){
				copy = draw(c.y, c.x, "LURD", map);
				dfs(i + 1, copy);
			}
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		check = new boolean[n][m];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0 && arr[i][j] != 6) cctv.add(new Cctv(i,j, arr[i][j]));
			}
		}
		dfs(0,arr);
		System.out.println(answer);
	}
}
