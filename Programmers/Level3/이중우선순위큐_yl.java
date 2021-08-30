import java.util.*;
/*
1시간 - Cheating : O
al.size() == 0이면 return 하는 문장을 for문 안에 줘버렸다.
난 바보얌
그리고 리턴하는건 pq.peek(), pqRev.peek() 이면 안 된다. 이미 지워진 원소일 수 있어서...
*/
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqRev = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> al = new ArrayList<>();

        for (int i=0; i<operations.length; i++) {
            String[] split = operations[i].split(" ");
            String alpha = split[0];
            String num = split[1];

            if (alpha.equals("I")) { // 큐에 숫자 삽입
                pq.add(Integer.parseInt(num));
                pqRev.add(Integer.parseInt(num));
                al.add(Integer.parseInt(num));
            }
            else if (alpha.equals("D")) {
                if (al.size() == 0) {
                    continue;
                }
                if (num.equals("1")) { // 큐에서 최댓값 삭제
                    int biggest = pqRev.poll();
                    al.remove(al.indexOf(biggest));
                }
                else if (num.equals("-1")) { // 큐에서 최솟값 삭제
                    int smallest = pq.poll();
                    al.remove(al.indexOf(smallest));
                }
            }

        }
        if (al.size() == 0) {
            return new int[] {0, 0};
        }
        Collections.sort(al);
        return new int[] {al.get(al.size()-1), al.get(0)};
    }
}