import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] degree = new int[n+1];
		Arrays.fill(degree, 0);
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		List[] lists = new List[n+1];
		for(int i = 1; i < n + 1; i++)
			lists[i] = new ArrayList<Integer>();

		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			degree[second]++;
			lists[first].add(second);
		}

		for(int i = 1; i < n + 1; i++){
			if(degree[i] == 0){
				pq.offer(i);
			}
		}
		List<Integer> result = new ArrayList<>();
		while(pq.size() > 0){
			int p = pq.poll();
			result.add(p);
			List<Integer> list = lists[p];
			for(int i : list){
				if(degree[i] != 0){
					degree[i]--;
				}

				if(degree[i]==0){
					pq.offer(i);
				}
			}
		}
		for(int i : result){
			System.out.print(i+ " ");
		}
	}
}
