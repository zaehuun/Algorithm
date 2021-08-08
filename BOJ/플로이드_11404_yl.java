import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
플로이드 와샬 - 모든 정점 간 최단경로
다익스트라 - 시작점부터 각 정점까지 최단경로

플로이드 와샬 이해가 안 된다 +_+...
*/
public class 플로이드_11404_yl {
    static int MAX_VAL = 100000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        int[][] dist = new int[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(dist[i], 100000000);
            dist[i][i] = 0; // 자기 자신은 0
        }
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int distBtwCities = Integer.parseInt(st.nextToken());
            if (dist[city1-1][city2-1] != -1) {
                dist[city1-1][city2-1] = Math.min(dist[city1-1][city2-1], distBtwCities);
            }
            else {
                dist[city1-1][city2-1] = distBtwCities;
            }
        }
        // 최단 경로 검색
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) { // k 지점 들렸다 가는거랑 비교
                    if (dist[i][j] > dist[i][k] + dist[k][j]) { // 플로이드 와샬은 이 한 줄이 다임
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dist[i][j] = dist[i][j] == 100000000? 0 : dist[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }

    }
}