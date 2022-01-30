import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		Arrays.fill(arr, 0);
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++){
				if(num == 0 && arr[j] == 0){
					arr[j] = i + 1;
					break;
				}
				else if(arr[j] == 0)
					num--;
			}
		}
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

	}
}
