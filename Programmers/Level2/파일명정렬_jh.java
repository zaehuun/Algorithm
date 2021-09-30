//파이썬으로는 10줄도 안 나온 문제였던 같은데..
//파이썬은 정렬 하기가 쉬웠다...
//자바는 좀 복작하네..

import java.util.*;
class Solution {
    public class file implements Comparable<file>{
        String original;
        String head;
        String number;
        String tail;
        
        public file(String name){
            original = name;
            head = "";
            number = "";
            tail = "";
            int idx = 0;
            String file = name.toLowerCase();
            for(int i = 0; i < file.length(); i++){
                char c = file.charAt(i);
                if(c >= '0' && c <= '9'){
                    idx = i;
                    break;
                }
                head = head + c;
            }
            int tailIdx = idx;
            for(int i = idx; i < file.length(); i++){
                char c = file.charAt(i);
                if(c >= 'a' && c <= 'z' || c == ' ' || c == '.' || c == '-'){
                    tailIdx = i;
                    break;
                }
                number = number + c;
            }
            if(tailIdx != idx) tail = file.substring(tailIdx);
        }
        
        @Override
        public int compareTo(file f) {
            if(f.head.equals(this.head))
                return Integer.compare(Integer.parseInt(number), Integer.parseInt(f.number));
            return head.compareTo(f.head);
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<file> list = new ArrayList<>();
        for(String f : files)
            list.add(new file(f));
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i).original;
        
        return answer;
    }
}
