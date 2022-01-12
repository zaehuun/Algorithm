import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static long calcTime(String date, String time){
		int month = Integer.parseInt(date.substring(5,7));
		int day = Integer.parseInt(date.substring(8,10));
		int hour = Integer.parseInt(time.substring(0,2));
		int min = Integer.parseInt(time.substring(3,5));

		int totalDay = 0;
		for(int i = 0; i < month; i++){
			totalDay += days[i];
		}
		totalDay += day;

		return min + hour * 60 + totalDay * 60 * 24;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String l = st.nextToken();
		int f = Integer.parseInt(st.nextToken());


		int rentalDay = Integer.parseInt(l.substring(0,3));
		int rentalHour = Integer.parseInt(l.substring(4,6));
		int rentalMin = Integer.parseInt(l.substring(7,9));
		long rentalTime = rentalMin + rentalHour * 60 + rentalDay * 60 * 24;

		Map<String, Long> book = new HashMap<>();
		Set<String> name = new HashSet<>();
		Map<String,Long> pay = new HashMap<>();
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken();
			String time = st.nextToken();
			String obj = st.nextToken();
			String person = st.nextToken();

			String key = obj + " " + person;
			long value = calcTime(date, time);
			if(!book.containsKey(key)){
				book.put(key,value);
			}
			else{
				long findValue = book.get(key);
				if(value - findValue > rentalTime){
					long fee = (value - findValue - rentalTime) * f;
					pay.put(person, pay.getOrDefault(person,0L) + fee);
					name.add(person);
				}
				book.remove(key);
			}
		}
		if(name.isEmpty()) {
			System.out.println(-1);
			return;
		}
		List<String> answer = new ArrayList<>();
		for(String p : name){
			answer.add(p);
		}
		Collections.sort(answer);
		for(String p : answer){
			System.out.println(p + " " + pay.get(p));
		}
	}
}

