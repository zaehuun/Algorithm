import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int  n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++){
			int v = Integer.parseInt(br.readLine());
			pq.offer(v);
		}
		if(pq.size() == 1) {
			System.out.println(0);
			return;
		}
		int answer = 0;
		while(pq.size() >2){
			int first = pq.poll();
			int second = pq.poll();
			int sum = first + second;
			answer += sum;
			pq.offer(sum);
		}

		int first = pq.poll();
		int second = pq.poll();
		System.out.println(answer + first + second);
	}
}
