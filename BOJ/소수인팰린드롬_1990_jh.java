import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[b+1];

		for(int i = 2; i * i <= b; i++){
			if(!check[i]){
				for(int j = i * i; j <= b; j += i) check[j] = true;
			}
		}
		for(int i = a; i<=b; i++){
			if(check[i] == false && isPD(i)) System.out.println(i);
		}
		System.out.println(-1);
	}
	public static boolean isPD(int i){
		String num = Integer.toString(i);
		String reverse = "";
		for(int idx = num.length() - 1; idx >= 0; idx--){
			reverse = reverse + num.charAt(idx);
		}
		return num.equals(reverse);
	}
}
