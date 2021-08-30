import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int total = 0;
		Map<String, Integer> map = new HashMap<>();
		while(s != null){
			if(map.containsKey(s)) map.put(s,map.get(s)+1);
			else map.put(s,1);
			total++;
			s = br.readLine();
		}

		Object[] key = map.keySet().toArray();
		Arrays.sort(key);
		
		for(Object k : key){
			String name = (String)k;
			int count = map.get(name);
			double p = (double)(count * 100) / total;
			System.out.println(name + " " + String.format("%.4f", p));
		}
	}
}

