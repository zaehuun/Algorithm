public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int answer = 987654321;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		int sum = 0;
		while(end <= N){
			if(sum < S){
				sum += arr[end];
				end++;
			}
			else{
				answer = Math.min(answer, end - start);
				sum -= arr[start];
				start++;
			}
		}
		if(answer == 987654321) System.out.println(0);
		else System.out.println(answer);
	}
}
/*
투포인터를 공부하고 투 포인터 문제를 풀어봤다.
처음엔 start부터 end까지 for문을 돌려 while 내에서 합을 구했는데 이러면 어찌보면 이중 for문이라 효율성이 떨어진다.
다른 코드들을 보니 저런 식으로 매번 sum의 값을 업데이트 시키며 구한다.
암튼 문제는 저것이 아니다.
아래 코드와 비교하면 while문 안에 있는 조건문들의 순서만 다르다.
하지만 결과는 다르다. 위 코드는 테스트 케이스가 10 10 / 1 1 1 1 1 1 1 1 1 10일경우 인덱스 익셉션이 발생된다.
도저히 해결아 안돼서 정답 코드를 찾아보니 조건문 순서만 달랐다. 그래서 걍 디버깅을 해봤다.
end가 딱 10을 가리키고 있고 (즉 end == 9) 17~19라인을 실행하면 sum은 19이고 end는 10이 된다.
그런 다음 16번째 라인을 실행하면 end <= N 즉 10 <= 10이기에 패스되고 17번째라인 검사를 한다.
sum은 19이기에 S보다 커서 걍 18 19 라인은 실행이 안 될 줄 알았다. 물론 실행이되면 arr[10]이기에 예외가 발생하는 것은 당연한거지만
걍 너무 아무 생각이 없었다.. 근데 이렇게까지 주석으로 남겨놓은 이유는 end가 10이 되고 18라인이 실행되면 예외가 발생 할 줄 알았는데
전애 19라인에서 end가 10이 되자마자 예외가 발생한다. 이게 컴파일러와 인터프리터의 차이인건가..
jvm 공부도 다시 할 겸 컴파일러와 인터프리터에 대해서도 공부를 좀 해야겠다.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int answer = 987654321;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		int sum = 0;
		while(true){
			if(sum >= S){
				answer = Math.min(answer, end - start);
				sum -= arr[start];
				start++;
			}
			else if(end == N) {break;}
			else{
				sum += arr[end];
				end++;
			}
		}
		if(answer == 987654321) System.out.println(0);
		else System.out.println(answer);
	}
}

