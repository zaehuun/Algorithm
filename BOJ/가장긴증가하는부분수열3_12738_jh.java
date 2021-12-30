import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		for(int i = 0; i < n; i++){
			int v = Integer.parseInt(st.nextToken());
			if(list.get(list.size() - 1) < v) list.add(v);
			else{
				int left = 1;
				int right = list.size() - 1;
				while(left < right){
					int mid = (left + right) / 2;
					if(list.get(mid) > v){
						right = mid;
					}
					else{
						left = mid + 1;
					}
				}
				list.set(right,v);
			}
		}
		System.out.println(list.size()-1);
	}
}
