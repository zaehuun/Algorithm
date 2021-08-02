import java.util.*;
class 키패드누르기_jh {
    public static void main(String[] args) {
      int[] numbers = {};
      String hand = "";
    // public String solution(int[] numbers, String hand) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(0,0));
        map.put(2, Arrays.asList(0,1));
        map.put(3, Arrays.asList(0,2));
        map.put(4, Arrays.asList(1,0));
        map.put(5, Arrays.asList(1,1));
        map.put(6, Arrays.asList(1,2));
        map.put(7, Arrays.asList(2,0));
        map.put(8, Arrays.asList(2,1));
        map.put(9, Arrays.asList(2,2));
        map.put(0, Arrays.asList(3,1));
        int[] left = {3,0};
        int[] right = {3,2};
        String answer = "";
        for(int num : numbers){
            // System.out.println(map.get(num));
            List<Integer> idx = map.get(num);
            if(Arrays.asList(1,4,7).contains(num)){
                left[0] = idx.get(0);
                left[1] = idx.get(1);
                answer += 'L';
            }else if(Arrays.asList(3,6,9).contains(num)){
                right[0] = idx.get(0);
                right[1] = idx.get(1);
                answer += 'R';
            }else{
                int row = idx.get(0);
                int col = idx.get(1);
                int leftDistance = Math.abs(left[0]-row) + Math.abs(left[1]-col);
                int rightDistance = Math.abs(right[0]-row) + Math.abs(right[1]-col);
                if (leftDistance < rightDistance){
                    left[0] = row;
                    left[1] = col;
                    answer += 'L';
                }else if (leftDistance > rightDistance){
                    right[0] = row;
                    right[1] = col;
                    answer += 'R';
                }else{
                    if(hand.equals("right")){
                        right[0] = row;
                        right[1] = col;
                        answer += 'R';
                    }
                    else{
                        left[0] = row;
                        left[1] = col;
                        answer += 'L';
                    }
                }
            }
        }
        return answer;
    }
}
