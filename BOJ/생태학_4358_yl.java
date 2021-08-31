import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
/*
20분 - Cheating : O
시간아까워서 김재훈꺼 배낌 낄낄
*/
public class 생태학_4358_yl {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        String s = br.readLine();
        while (s != null) {
            if(hm.containsKey(s)) {
                hm.put(s, hm.get(s)+1);
            }
            else {
                hm.put(s,1);
            }
            cnt++;
            s = br.readLine();
        }

        Object[] key = hm.keySet().toArray();
		Arrays.sort(key);

		for(Object k : key){
			String name = (String)k;
			int count = hm.get(name);
			double p = (double)(count * 100) / cnt;
			System.out.println(name + " " + String.format("%.4f", p));
		}
    }
}
