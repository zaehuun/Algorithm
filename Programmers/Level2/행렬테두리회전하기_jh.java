import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++)
            answer[i] = rows * columns + 1;
        int[][] arr = new int[rows][columns];
        
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++)
                arr[i][j] = num++;
        }
        for(int i = 0; i < queries.length; i++){
            int srow = queries[i][0] - 1;
            int scol = queries[i][1] - 1;
            int erow = queries[i][2] - 1;
            int ecol = queries[i][3] - 1;
            
            int dupNum = arr[srow][ecol];
            for(int x = ecol; x > scol; x--){
                arr[srow][x] = arr[srow][x-1];
                answer[i] = Math.min(answer[i], arr[srow][x]);
            }
            
            int dupNum2 = arr[erow][ecol];
            for(int y = erow; y > srow + 1; y--){
                arr[y][ecol] = arr[y-1][ecol];
                answer[i] = Math.min(answer[i], arr[y][ecol]);
            }
            arr[srow+1][ecol] = dupNum;
            
            int dupNum3 = arr[erow][scol];
            for(int x = scol; x < ecol; x++){
                arr[erow][x] = arr[erow][x+1];
                answer[i] = Math.min(answer[i], arr[erow][x]);
            }
            arr[erow][ecol-1] = dupNum2;
            
            for(int y = srow; y < erow; y++){
                arr[y][scol] = arr[y+1][scol];
                answer[i] = Math.min(answer[i], arr[y][scol]);
            }
            arr[erow-1][scol] = dupNum3;

            List<Integer> list = Arrays.asList(dupNum, dupNum2, dupNum3);
            answer[i] = Math.min(answer[i], Collections.min(list));

        }
        return answer;
    }

}
