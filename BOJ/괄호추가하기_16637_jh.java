import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static List<Integer> number = new ArrayList<>();
	static List<Character> op = new ArrayList<>();
	static int answer = Integer.MIN_VALUE;
	public static int calc(char c, int a, int b){
		if(c == '+') return a + b;
		if(c == '-') return a - b;
		if(c == '*') return a * b;
		return 0;
	}
	public static void dfs(int idx, int sum){
		if(idx >= op.size()){
			answer = Math.max(answer,sum);
			return;
		}

		int result = calc(op.get(idx), sum, number.get(idx+1));
		dfs(idx+1,result);

		if(idx+1<op.size()){
			result = calc(op.get(idx+1), number.get(idx+1), number.get(idx+2));
			result = calc(op.get(idx), sum, result );
			dfs(idx+2, result);
		}


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String st =br.readLine();

		for(char c : st.toCharArray()){
			if(c == '+' || c == '-' || c== '*')
				op.add(c);
			else
				number.add(c - '0');
		}
		dfs(0,number.get(0));
		System.out.println(answer);
	}
}
