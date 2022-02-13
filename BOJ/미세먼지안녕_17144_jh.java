import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static int r;
	public static int c;
	public static int[][] arr;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};

	public static void spread(){
		int[][] weight = new int[r][c];

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(arr[i][j] == 0 || arr[i][j] == -1) continue;

				//확산양
				int outDust = (int)Math.floor((double) arr[i][j] / 5);

				int count = 0;
				for(int k = 0; k < 4; k++){
					int ty = i + dy[k];
					int tx = j + dx[k];

					if(ty < 0 || tx < 0 || ty >= r || tx >= c) continue;
					if(arr[ty][tx] == -1) continue;

					weight[ty][tx] += outDust;
					count++;
				}
				arr[i][j] = arr[i][j] - (arr[i][j]/5) * count;
			}
		}

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(arr[i][j] == -1) continue;
				arr[i][j] = arr[i][j] + weight[i][j];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		arr = new int[r][c];

		int my1=-1;
		int my2=-1;
		for(int i = 0; i < r; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1){
					my2 = i;
				}
			}
		}
		my1 = my2 - 1;

		while(t > 0){
			spread();

			//위순환
			for (int i = my1 - 1; i > 0; i--)
				arr[i][0] = arr[i-1][0];

			for (int i = 0; i < c - 1; i++)
				arr[0][i] = arr[0][i+1];

			for (int i = 0; i < my1; i++)
				arr[i][c - 1] = arr[i + 1][c - 1];

			for (int i = c - 1; i > 1; i--)
				arr[my1][i] = arr[my1][i-1];
			arr[my1][1] = 0;

			//아래순환
			for (int i = my2 + 1; i < r - 1; i++)
				arr[i][0] = arr[i + 1][0];

			for (int i = 0; i < c - 1; i++)
				arr[r - 1][i] = arr[r - 1][i + 1];

			for (int i = r - 1; i > my2; i--)
				arr[i][c - 1] = arr[i - 1][c - 1];

			for (int i = c - 1; i > 1; i--)
				arr[my2][i] = arr[my2][i - 1];

			arr[my2][1] = 0;
			t--;
		}
		int answer = 0;
		for(int i = 0; i < r; i++){

			for(int j = 0; j < c; j++){
				if(arr[i][j] == 0 || arr[i][j] == -1) continue;
				answer = answer + arr[i][j];
			}
		}
		System.out.println(answer);
	}
}
