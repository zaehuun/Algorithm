import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String number = br.readLine();

		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for(int idx = 0; idx < n; idx++){
			int num = number.charAt(idx) - '0';
			while(count < k && !stack.isEmpty() && stack.peek() < num){
				stack.pop();
				count++;
			}
			stack.add(num);
		}
		for(int i = 0; i < n - k; i++){
			System.out.print(stack.elementAt(i));
		}
	}
}

