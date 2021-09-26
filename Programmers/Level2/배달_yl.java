import java.util.*;
/*
20분 - Cheating : O
다익스트라를 외워야한다.
*/
class Solution {
    static class Node {
        int n;
        int cost;
        Node (int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        for (int i=0; i<N; i++) { // 초기화
			map.add(new ArrayList<Node>());
		}
        for (int i=0; i<road.length; i++) { // 인접행렬 생성
            map.get(road[i][0]-1).add(new Node(road[i][1]-1, road[i][2]));
            map.get(road[i][1]-1).add(new Node(road[i][0]-1, road[i][2]));
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost)); // cost 작은 것 우선
        pq.add(new Node(0, 0)); // 0에서 0가는건 비용 0
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.n] < cur.cost) {
				continue;
			}
            for (int i=0; i<map.get(cur.n).size(); i++) {
				Node next = map.get(cur.n).get(i);
				if (dist[next.n] > cur.cost + next.cost) {
					dist[next.n] = cur.cost + next.cost;
					pq.add(new Node(next.n, dist[next.n]));
				}
			}
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            if (K >= dist[i]) {
                answer++;
            }
        }
        return answer;
    }
}