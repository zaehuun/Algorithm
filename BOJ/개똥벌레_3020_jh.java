import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] top = new int[H+1];
		int[] bottom = new int[H+1];

		for(int i = 0; i < N / 2; i++){
			top[Integer.parseInt(br.readLine())]++;
			bottom[Integer.parseInt(br.readLine())]++;
		}

		for(int i = 1; i <= H; i++){
			top[i] = top[i] + top[i-1];
			bottom[i] = bottom[i] + bottom[i-1];
		}

		int min = 200000000;
		int cnt = 0;
		for(int i = 1; i <= H; i++){
			int c = 0;

			c += bottom[H] - bottom[i-1];
			c += top[H] - top[H - i];

			if(min > c){
				min = c;
				cnt = 1;
			}
			else if(min == c) cnt++;
		}

		System.out.println(min + " " + cnt);
	}
}


