import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static List<String> answer;
	public static void dfs(int num, String exp, int max){
		if(num > max) {
			String prev = "";
			int sum = 0;
			int lastSign = 1;
			for(char c : exp.toCharArray()){
				if(c == ' ') continue;
				if(c >= '1' && c <= '9') {
					prev = prev + c;
					continue;
				}
				if(lastSign == 1) sum += Integer.parseInt(prev);
				else sum -= Integer.parseInt(prev);
				lastSign = c == '+' ? 1 : 0;
				prev = "";
			}
			if(lastSign == 1 && sum + Integer.parseInt(prev) == 0) answer.add(exp);
			if(lastSign == 0 && sum - Integer.parseInt(prev) == 0) answer.add(exp);
			return;
		}
		dfs(num+1, exp + " " + num, max);
		dfs(num+1, exp + "+" + num, max);
		dfs(num+1, exp + "-" + num, max);

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase > 0){
			int N = Integer.parseInt(br.readLine());
			answer = new ArrayList<String>();
			dfs(2, "1", N);
			for(String st : answer){
				System.out.println(st);
			}
			System.out.println();
			testCase--;
		}
	}
}


