import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		arr = new int[h][w];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < w; i++){
			for(int j = h - Integer.parseInt(st.nextToken()); j < h; j++){
				arr[j][i] = 1;
			}
		}

		int answer = 0;
		for(int i = 0; i < h; i++){
			boolean flag = false;
			int count = 0;
			for(int j = 0; j < w; j++){
				if(arr[i][j] == 1){
					flag = true;
					answer += count;
					count = 0;
				}
				else if(arr[i][j] == 0 && flag){
					count++;
				}
			}
		}
		System.out.println(answer);
	}
}

