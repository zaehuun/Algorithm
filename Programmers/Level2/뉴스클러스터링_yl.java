import java.util.*;
/*
2시간 - Cheating : O
정말 짜증나는 문제다!
*/
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        String s1 = str1.toUpperCase();
		String s2 = str2.toUpperCase();

		HashMap<String, Integer> hm1 = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();

		for (int i=0; i<s1.length()-1; i++) {
			String s = s1.substring(i, i+2);
			if (!('A' <= s.charAt(0) && s.charAt(0) <= 'Z' &&
					'A' <= s.charAt(1) && s.charAt(1) <= 'Z'))
				continue ;
			if (hm1.containsKey(s))
				hm1.put(s, hm1.get(s)+1);
			else
				hm1.put(s, 1);
		}
		for (int i=0; i<s2.length()-1; i++) {
			String s = s2.substring(i, i+2);
			if (!('A' <= s.charAt(0) && s.charAt(0) <= 'Z' &&
					'A' <= s.charAt(1) && s.charAt(1) <= 'Z'))
				continue ;
			if (hm2.containsKey(s))
				hm2.put(s, hm2.get(s)+1);
			else
				hm2.put(s, 1);
		}

		int sum = 0; //합집합 원소 개수
		int inter = 0; //교집합 원소 개수
		for (HashMap.Entry<String, Integer> entry : hm1.entrySet()) {
			if (hm2.containsKey(entry.getKey())) {
				sum += Math.max(entry.getValue(), hm2.get(entry.getKey()));
		    	inter += Math.min(entry.getValue(), hm2.get(entry.getKey()));
		    }
			else {
				sum += entry.getValue();
			}
		}

		for (HashMap.Entry<String, Integer> entry : hm2.entrySet()) {
			if (!hm1.containsKey(entry.getKey()))
				sum += entry.getValue();
		}

		if (sum == 0 && inter == 0) {
			answer = 1 * 65536;
			return answer;
		}
		double ans = (double)inter / (double)sum;
		answer = (int)(ans * 65536);
        return answer;
    }
}