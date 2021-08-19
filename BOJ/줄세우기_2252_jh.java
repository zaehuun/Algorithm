import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N+1]; //본인을 가리키는 간선의 수를 기록
		List<List<Integer>> arr = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			arr.add(new ArrayList<>());

		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			indegree[b]++; //본인을 가리키는 간선 수 증가시킴
		}
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++){
			if(indegree[i] == 0) //본인을 가리키는 간선의 수가 0이면
				que.offer(i);
		}
		List<Integer> result = new ArrayList<>();
		while(!que.isEmpty()){
			int e = que.poll();
			result.add(e);

			for(int i : arr.get(e)){
				indegree[i]--;
				if(indegree[i] == 0) //본인을 가라키는 간선의 수가 사라지면
					que.offer(i);
			}
		}
		for(int i : result){
			System.out.print(i + " ");
		}
	}
}
