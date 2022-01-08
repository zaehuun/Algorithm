import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static boolean check = false;
	public static boolean isValid(String word1, String word2, String word3){
		Map<Character, Integer> map = new HashMap<>();
		for(char c : word1.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for(char c : word2.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for(char c : word3.toCharArray()){
			if(!map.containsKey(c)) return false;
			map.put(c, map.get(c) - 1);
			if(map.get(c) == 0){
				map.remove(c);
			}
		}
		if(map.size() > 0) return false;
		return true;
	}
	public static void dfs(String word1, String word2, String word3, String temp, int idx1, int idx2, int idx3){
		if(check) return;
		if(idx1 + idx2  == word3.length()){
			check = true;
			return;
		}

		if(idx1 < word1.length() && word1.charAt(idx1) == word3.charAt(idx3)){
			dfs(word1, word2, word3, temp + word1.charAt(idx1), idx1+1, idx2, idx3+1);
		}
		if(idx2 < word2.length() && word2.charAt(idx2) == word3.charAt(idx3)){
			dfs(word1, word2, word3, temp + word2.charAt(idx2), idx1, idx2 + 1, idx3+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i = 1; i <= t; i++){

			StringTokenizer st = new StringTokenizer(br.readLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			String word3 = st.nextToken();
			if(!isValid(word1, word2, word3)){
				System.out.println("Data set " + i + ": no");
				continue;
			}
			dfs(word1, word2, word3, "",0,0,0);
			if(check){
				System.out.println("Data set " + i + ": yes");
			}
			else{
				System.out.println("Data set " + i + ": no");
			}
			check = false;
		}

	}
}

