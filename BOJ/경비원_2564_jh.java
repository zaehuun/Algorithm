import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] store = new int[n][2];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());


		for(int[] pos : store){
			int blockDir = pos[0];
			int blockDist = pos[1];

			if(dir == 1){
				if(blockDir == 1){
					answer = answer + Math.abs(dist - blockDist);
				}
				else if(blockDir == 2){
					answer = answer + r + Math.min(dist + blockDist, (c - dist) + (c - blockDist));
				}
				else if(blockDir == 3){
					answer = answer + dist + blockDist;
				}
				else{
					answer = answer + (c - dist) + blockDist;
				}
			}

			else if(dir == 2){
				if(blockDir == 1){
					answer = answer + r + Math.min(dist + blockDist, (c-dist) + (c - blockDist));
				}
				else if(blockDir == 2){
					answer = answer + Math.abs(dist - blockDist);
				}
				else if(blockDir == 3){
					answer = answer + dist + (r - blockDist);
				}
				else{
					answer = answer + (c - dist) + (r - blockDist);
				}
			}


			else if(dir == 3){
				if(blockDir == 1){
					answer = answer + dist + blockDist;
				}
				else if(blockDir == 2){
					answer = answer + (r - dist) + blockDist;
				}
				else if(blockDir == 3){
					answer = answer + Math.abs(dist - blockDist);
				}
				else{
					answer = answer + Math.min(dist + c + blockDist, (r - dist) + c + (r - blockDist));
				}
			}
			//1 : 북, 2 : 남, 3 : 서, 4 : 덩
			else{
				if(blockDir == 1){
					answer = answer + dist + (c - blockDist);
				}
				else if(blockDir == 2){
					answer = answer + (r - dist) + (c - blockDist);
				}
				else if(blockDir == 3){
					answer = answer + Math.min(dist + c + blockDist, (r-dist) + c + (r - blockDist));
				}
				else{
					answer = answer + Math.abs(dist - blockDist);
				}
			}
		}
		System.out.println(answer);
	}
}

