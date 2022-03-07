import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static int n;
	public static List<Long> list = new ArrayList<>();
	public static void perm(long num, int len){
		if(len > 10) return;
		list.add(num);
		for(int i = 0; i < 10; i++){
			if(num % 10 > i){
				perm(num  * 10 + i, len + 1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		if(n <= 10){
			System.out.println(n);
		}
		else if(n > 1022){
			System.out.println(-1);
		}
		else{
			for(int i = 0; i < 10; i++){
				perm(i, 1);
			}
			Collections.sort(list);
			System.out.println(list.get(n));
		}
//		StringTokenizer st = new StringTokenizer(br.readLine());
	}
}
