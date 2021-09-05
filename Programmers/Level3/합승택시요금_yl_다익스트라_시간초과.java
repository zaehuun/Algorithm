import java.util.*;
/*
2시간 - Cheating : O
다익스트라 ver => 시간초과
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
    public int solution(int n, int s, int a, int b, int[][] fares) {
        ArrayList<ArrayList<Node>> map = new ArrayList<>();
        for (int i=0; i<n; i++) { // 초기화
			map.add(new ArrayList<Node>());
		}
        for (int i=0; i<fares.length; i++) { // 인접행렬 생성
            map.get(fares[i][0]-1).add(new Node(fares[i][1]-1, fares[i][2]));
            map.get(fares[i][1]-1).add(new Node(fares[i][0]-1, fares[i][2]));
        }

        // S ~ 같이 타고 가는 구간
        int[] distFromS = new int[n];
        Arrays.fill(distFromS, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(s-1, 0));
        distFromS[s-1] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (distFromS[curNode.n] < curNode.cost) {
				continue;
			}
            for (int i=0; i<map.get(curNode.n).size(); i++) {
				Node nextNode = map.get(curNode.n).get(i);
				if (distFromS[nextNode.n] > curNode.cost + nextNode.cost) {
					distFromS[nextNode.n] = curNode.cost + nextNode.cost;
					pq.add(new Node(nextNode.n, distFromS[nextNode.n]));
				}
			}
        }
        //System.out.println(Arrays.toString(distFromS));
        // 같이 타고 가는 구간 ~ A집, 같이 타고 가는 구간 ~ B집
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            //System.out.println("i = "+i);
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.clear();
            pq.add(new Node(i, 0));
            dist[i] = 0;
            while (!pq.isEmpty()) {
                Node curNode = pq.poll();

                if (dist[curNode.n] < curNode.cost) {
		    		continue;
		    	}
                for (int j=0; j<map.get(curNode.n).size(); j++) {
		    		Node nextNode = map.get(curNode.n).get(j);

		    		if (dist[nextNode.n] > curNode.cost + nextNode.cost) {
		    			dist[nextNode.n] = curNode.cost + nextNode.cost;
		    			pq.add(new Node(nextNode.n, dist[nextNode.n]));
		    		}
		    	}
            }
            answer = Math.min(answer, distFromS[i] + dist[a-1] + dist[b-1]);
        }
        return answer;
    }

}