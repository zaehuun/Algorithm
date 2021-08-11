import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<Integer>();
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, (a,b)->(a.length()-b.length()));
        for(String st : arr){
            String[] nums = st.split(",");
            for(String num : nums){
                if(!list.contains(Integer.parseInt(num)))
                    list.add(Integer.parseInt(num));          
            }
        }
        int[] answer = new int[list.size()];
        System.out.println(list.get(0));
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
