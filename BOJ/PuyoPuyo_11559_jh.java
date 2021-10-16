import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static char[][] arr = new char[12][6];
	public static int[] dy = {1,-1,0,0};
	public static int[] dx = {0,0,1,-1};
	public static boolean[][] visit;
	public static List<node> list;
	public static class node{
		int y;
		int x;
		public node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

	public static void dfs(char target, int y, int x){
		for(int i = 0; i < 4; i++){
			int ty = y + dy[i];
			int tx = x + dx[i];

			if(ty < 0 || ty >= 12 || tx < 0 || tx >= 6) continue;
			if(visit[ty][tx]) continue;
			if(arr[ty][tx] == '.') continue;
			if(arr[ty][tx] != target) continue;
			visit[ty][tx] = true;
			list.add(new node(ty,tx));
			dfs(target,ty,tx);
		}
	}
	public static void fillArray() {
		for (int i = 0; i < 6; i++) {
			List<Character> tmp = new ArrayList<>();
			for (int j = 11; j >= 0; j--) {
				if(arr[j][i] == '.') continue;
				tmp.add(arr[j][i]);
				arr[j][i] = '.';
			}
			int idx = 11;
			for(int j = 0; j < tmp.size(); j++){
				arr[idx][i] = tmp.get(j);
				idx--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 12; i++){
			String st = br.readLine();
			for(int j = 0; j < 6; j++)
				arr[i][j] = st.charAt(j);
		}
		int answer = 0;
		while(true){
			boolean flag = true;
			for(int i = 0; i < 12; i++){
				for(int j = 0; j < 6; j++){
					if(arr[i][j] == '.') continue;
					visit = new boolean[12][6];
					list = new ArrayList<node>();
					dfs(arr[i][j],i,j);
					if(list.size() >= 4){
						flag = false;
						for(node n : list)
							arr[n.y][n.x] = '.';
					}
				}
			}
			if(flag) break;
			fillArray();
			answer++;
		}
		System.out.println(answer);
	}
}


