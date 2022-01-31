import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static class student implements Comparable<student>{
		int num;
		int like;
		int time;

		public student(int num, int like, int time){
			this.num = num;
			this.like = like;
			this. time = time;
		}

		@Override
		public int compareTo(student o) {
			if(this.like == o.like){
				return this.time - o.time;
			}
			else if(this.like < o.like) return -1;
			return 1;

		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<student> list = new ArrayList<>();

		boolean[] check = new boolean[101];
		for(int i = 0; i < k; i++){
			int target = Integer.parseInt(st.nextToken());
			if(list.size() < n){
				//액자가 여유 있을 경우
				if(check[target]){
					//이미 액자에 있을 경우
					for(student std : list){
						if(std.num == target){
							std.like++;
							break;
						}
					}
				}
				else{
					//없을 경우
					list.add(new student(target,1,i));
					check[target] = true;
				}
			}
			else{
				//액자가 다 찬 경우
				Collections.sort(list);
				if(check[target]){
					for(student std : list){
						if(std.num == target){
							std.like++;
							break;
						}
					}
				}
				else{
					student s = list.get(0);
					check[s.num] = false;
					list.remove(0);

					list.add(new student(target, 1, i));
					check[target] = true;
				}

			}
		}
		for(int i = 0; i < 101; i++){
			if(check[i]) System.out.print(i + " ");
		}
	}
}
