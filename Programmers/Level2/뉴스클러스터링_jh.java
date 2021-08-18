import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String,Integer> a = new HashMap<>();
        Map<String,Integer> b = new HashMap<>();
        int answer = 0;
        for(int i = 1; i < str1.length(); i++){
            char one = str1.charAt(i-1);
            char two = str1.charAt(i);
            if(one >= 'a' && one <= 'z' && two >= 'a' && two <= 'z'){
                String key = Character.toString(one)+Character.toString(two);
                if(a.containsKey(key)) a.put(key,a.get(key)+1);
                else a.put(key, 1);
            }
        }
        for(int i = 1; i < str2.length(); i++){
            char one = str2.charAt(i-1);
            char two = str2.charAt(i);
            if(one >= 'a' && one <= 'z' && two >= 'a' && two <= 'z'){
                String key = Character.toString(one)+Character.toString(two);
                if(b.containsKey(key)) b.put(key,b.get(key)+1);
                else b.put(key, 1);
            }
        }
        if(a.size() == 0 && b.size() == 0) return 1 * 65536;
        int inter = 0;
        int all = 0;
        for(String key : a.keySet())
            if(b.containsKey(key)) inter = inter + Math.min(a.get(key),b.get(key));
        
        for(String key : a.keySet()){
            if(b.containsKey(key)) all = all + Math.max(a.get(key),b.get(key));
            else all += a.get(key);
        }
        for(String key : b.keySet()){
            if(!a.containsKey(key)) all += b.get(key);
        }
        float result = (float)inter/all * 65536;
        return (int)result ;
    }
}
