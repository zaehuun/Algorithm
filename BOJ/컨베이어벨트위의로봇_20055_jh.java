import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int n;
	public static int k;
	public static boolean[] robot;
	public static int[] belt;
	public static void moveBelt(){

		int last = belt[2 * n - 1];
		for(int i = 2 * n - 1; i > 0; i--){
			belt[i] = belt[i-1];
		}
		belt[0] = last;

		for(int i = 2 * n - 1; i > 0; i--){
			robot[i] = robot[i-1];
		}
		robot[0] = false;
		robot[n-1] = false;
	}
	public static void moveRobot(){
		for(int i = n - 2; i >= 0; i--){
			if(robot[i] == false) continue;
			if(robot[i + 1]) continue;
			if(belt[i+1] <= 0) continue;

			robot[i] = false;
			robot[i+1] = true;
			belt[i+1]--;
		}

		robot[n-1] = false;
	}

	public static void putRobot(){
		if(belt[0] > 0 && robot[0] == false){
			belt[0]--;
			robot[0] = true;
		}
	}

	public static boolean check(){
		int cnt = 0;
		for(int i = 0; i < 2 * n; i++){
			if(belt[i] <= 0) cnt++;
		}
		return cnt < k;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		robot = new boolean[2 * n];
		belt = new int[2 * n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * n; i++){
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int step = 0;
		while(check()){
			step++;
			moveBelt();
			moveRobot();
			putRobot();
		}
		System.out.println(step);

	}
}
