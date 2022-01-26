import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static String[] c = new String[4];
	public static void turn(int idx, int dir){
		if(dir == 1){
			char d = c[idx].charAt(c[idx].length() - 1);
			c[idx] = d + c[idx].substring(0,c[idx].length() - 1);
		}
		else{
			char d = c[idx].charAt(0);
			c[idx] = c[idx].substring(1, c[idx].length()) + d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 4; i++){
			c[i] = br.readLine();
		}
		
		int k = Integer.parseInt(br.readLine());

		while(k > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			char left = c[target].charAt(6);
			char right = c[target].charAt(2);
			//왼쪽

			int leftT = target-1;
			int leftDir = dir;
			while(leftT >= 0){
				if(c[leftT].charAt(2) == left) break;
				left = c[leftT].charAt(6);
				turn(leftT, leftDir * -1);
				leftDir = leftDir * -1;
				leftT--;
			}

			int rightT = target + 1;
			int rightDir = dir;
			while(rightT < 4){
				if(c[rightT].charAt(6) == right) break;
				right = c[rightT].charAt(2);
				turn(rightT, rightDir * -1);
				rightDir = rightDir * -1;
				rightT++;
			}

			turn(target,dir);
			k--;
		}

		int answer = 0;
		for(int i = 0; i < 4; i++){
			if(c[i].charAt(0) == '1') answer += Math.pow(2,i);
		}
		System.out.println(answer);
	}
}
