import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Pos{
		int y;
		int x;
		public Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int d = 4;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[y-1][x-1] = 9; //사과는 9
		}
		Map<Integer,String> command = new HashMap<>();
		Deque<Pos> snake = new ArrayDeque<>();
		int L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++){
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			command.put(time,dir);
		}
		snake.offer(new Pos(0,0));
		arr[0][0] = 1;
		int time = 0;
		while(true){
			time++;
			Pos head = snake.peekFirst();
			Pos newHead = new Pos(head.y,head.x);
			if(d == 4) newHead.x++; //오른쪽
			else if(d == 3) newHead.y--; //위
			else if(d == 2) newHead.x--; //왼쪽
			else if(d== 1) newHead.y++; //아래
			if(newHead.y < 0 || newHead.y >= N || newHead.x < 0 || newHead.x >= N)
				break;
			if(arr[newHead.y][newHead.x] == 1)
				break;
			arr[newHead.y][newHead.x] = 1;
			if(arr[newHead.y][newHead.x] == 9){
				snake.offerFirst(newHead);
			}
			else{
				snake.offerFirst(newHead);
				Pos tail = snake.pollLast();
				arr[tail.y][tail.x] = 0;
			}
			if(command.containsKey(time)){
				String dir = command.get(time);
				if(dir.equals("L")){
					d = d - 1;
					if(d < 1) d = 4;
				}
				else{
					d = d + 1;
					if(d > 4) d = 1;
				}
			}
		}
		System.out.println(time);

	}
}
