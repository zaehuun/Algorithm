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
		for(int i = 0; i < n; i++){
			list.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> result = new ArrayList<>();
		result.add(0);

		for(int i = 0; i < list.size(); i++){
			int v = list.get(i);
			if(result.get(result.size() - 1) < v){
				result.add(v);
			}
			else{
				int left = 0;
				int right = result.size() - 1;
				while(left < right){
					int mid = (left + right) / 2;
					if(result.get(mid) < v){
						left = mid + 1;
					}
					else{
						right = mid;
					}
				}
				result.set(right,v);
			}
		}
		System.out.println(result.size() - 1);

	}

}
