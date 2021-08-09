import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
1시간 - Cheating : X
플로이드 와샬 이해가 안 된다 +_+...
맞았는데 왜 맞았는지 모르겟섭... 감으로 맞혔달까..
*/
public class 키순서_2458_yl {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 학생들의 수
            int M = Integer.parseInt(st.nextToken()); // 두 학생 키를 비교한 횟수

            int[][] heightCmp = new int[N][N];
            for (int i=0; i<N; i++) {
                Arrays.fill(heightCmp[i], -1);
            }
            for (int i=0; i<M; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st1.nextToken());
                int s2 = Integer.parseInt(st1.nextToken());
                // s1 < s2
                heightCmp[s1-1][s2-1] = 0; // 짐
                heightCmp[s2-1][s1-1] = 1; // 이김
            }
            // for (int i=0; i<N; i++) {
            //     for (int j=0; j<N; j++) {
            //         System.out.print(heightCmp[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            for (int k=0; k<N; k++) {
                for (int i=0; i<N; i++) {
                    for (int j=0; j<N; j++) {
                        if (heightCmp[i][k] == heightCmp[k][j] && heightCmp[k][j] != -1) {
                            heightCmp[i][j] = heightCmp[i][k];
                        }
                    }
                }
            }
            // for (int i=0; i<N; i++) {
            //     for (int j=0; j<N; j++) {
            //         System.out.print(heightCmp[i][j]+"   ");
            //     }
            //     System.out.println();
            // }
            int answer = 0;
            for (int i=0; i<N; i++) {
                boolean answerFlag = true;
                for (int j=0; j<N; j++) {
                    if (i != j && heightCmp[i][j] == -1) {
                        answerFlag = false;
                    }
                }
                if (answerFlag) {
                    answer++;
                }
            }
            System.out.println(answer);
        }

}
