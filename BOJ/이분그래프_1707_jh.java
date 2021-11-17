//아니 이분 그래프가 둘로 나눠지는 그래프라 생각했는데 그게 아니었다..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		while(K != 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			List<Integer>[] list = new ArrayList[v];
			for(int i = 0; i < v; i++)
				list[i] = new ArrayList<>();

			for(int i = 0; i < e; i++){
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				list[start-1].add(end-1);
				list[end-1].add(start-1);
			}

			Queue<Integer> que = new LinkedList<>();

			int[] visit = new int[v];
			boolean flag = false;
			for(int i = 0; i < v; i++) {
				if (visit[i] != 0) continue;

				visit[i] = 1;
				que.offer(i);


				while (!que.isEmpty()) {
					int idx = que.poll();

					for (int target : list[idx]) {
						if (visit[target] == 0) {
							que.offer(target);
							visit[target] = visit[idx] * -1;

						} else if(visit[target] == visit[idx]) {
							flag = true;
							break;
						}
					}
					if(flag) break;
				}
				if(flag) break;
			}
			if(flag) System.out.println("NO");
			else System.out.println("YES");
			K--;
		}



	}
}
