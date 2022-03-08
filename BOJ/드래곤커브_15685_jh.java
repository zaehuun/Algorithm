import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[101][101];

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());

			List<Integer> list = new ArrayList<>();
			list.add(dir);
			arr[y][x] = true;
			for(int g = 0; g < gen; g++){
				for(int idx = list.size() - 1; idx >= 0; idx--){
					list.add((list.get(idx)+1) % 4);
				}
			}

			int nx = x;
			int ny = y;
			for(int d : list){

				nx = x + dx[d];
				ny = y + dy[d];

				arr[ny][nx] = true;

				x = nx;
				y = ny;
			}

		}

		int answer = 0;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) answer++;
			}
		}
		System.out.println(answer);

	}
}
