import java.util.*;
class Solution {
    class Node{
        int pr;
        int location;
        Node(int pr, int location){
            this.pr = pr;
            this.location = location;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++)
            que.offer(new Node(priorities[i],i));
        while (que.size() > 0){
            Node node = que.poll();
            boolean flag = true;
            for(Node p : que){
                if(p.pr > node.pr){
                    que.offer(node);
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(node.location == location) return answer;
                answer++;
            }
            
        }
        return 0;
    }
}
