import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int[] op = new int[4];
	public static List<Integer> list = new ArrayList<>();
	public static void dfs(int sum, int idx, int totalCount){
		if(totalCount == list.size() ){
			max = Math.max(max,sum);
			min = Math.min(min,sum);
			return;
		}
		for(int i = idx; i < list.size(); i++){
			if(op[0] != 0){
				op[0]--;
				dfs(sum+list.get(i), i+ 1,totalCount+1);
				op[0]++;
			}
			if(op[1] != 0){
				op[1]--;
				dfs(sum-list.get(i),i+ 1, totalCount+1);
				op[1]++;
			}
			if(op[2] != 0){
				op[2]--;
				dfs(sum*list.get(i),i+ 1, totalCount+1);
				op[2]++;
			}
			if(op[3] != 0){
				op[3]--;
				dfs(sum/list.get(i),i+ 1,totalCount+1);
				op[3]++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++)
			list.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		dfs(list.get(0),1, 1);
		System.out.println(max);
		System.out.println(min);
	}
}
