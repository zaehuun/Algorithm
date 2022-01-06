import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static boolean[] alpha = new boolean[26];
	public static void dfs(String[] arr, String st, int l, int idx){
		if(st.length() == l){
			char[] toChar = st.toCharArray();

			int moCnt = 0;
			int zaCnt = 0;
			for(char c : toChar){
				if(alpha[c - 'a']) moCnt++;
				else zaCnt++;
			}
			
			if(moCnt < 1) return;
			if(zaCnt < 2) return;
			System.out.println(st);
			return;
		}
		for(int i = idx; i < arr.length; i++){
			String s = st + arr[i];
			dfs(arr, s, l, i + 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		alpha[0] = true;
		alpha[4] = true;
		alpha[8] = true;
		alpha[14] = true;
		alpha[20] = true;

		String[] arr = new String[c];
		for(int i = 0; i < c; i++)
			arr[i] = st.nextToken();
		Arrays.sort(arr);
		dfs(arr, "", l, 0);
	}
}

