import java.util.*;
class Solution {
    class Node{
        int e;
        int cnt;
        Node(int e, int cnt){
            this.e = e;
            this.cnt = cnt;
        }
    }
    public int bfs(List<List<Integer>> arr, int n){
        int answer = 0;
        Queue<Node> que = new LinkedList<Node>();
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        que.offer(new Node(1,0));
        int max = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            int t = node.e;
            int cnt = node.cnt;
            if(cnt == max) answer++;
            if(cnt > max){
                max = cnt;
                answer = 1;
            }
            for(int i : arr.get(t)){
                if(i == 0) continue;
                if(visit[i]) continue;
                visit[i] = true;
                que.offer(new Node(i,cnt+1));
            }
        }
        
        return answer;
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            arr.add(new ArrayList<>());
        for(int[] v : edge){
            arr.get(v[0]).add(v[1]);
            arr.get(v[1]).add(v[0]);
        }
        return bfs(arr,n);
    }
}
