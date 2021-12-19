import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmds) {
        boolean[] arr = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(arr, true);
        int position = k;
        int move = 0;
        for(String cmd : cmds){
            String[] word = cmd.split(" ");
            if(word[0].equals("D")){
                move += Integer.parseInt(word[1]);
            }
            else if(word[0].equals("U")){
                move -= Integer.parseInt(word[1]);
            }
            else if(word[0].equals("C")){
                position = movePosition(position, move, arr);
                move = 0;
                
                arr[position] = false;
                stack.add(position);
                boolean flag = false;
                for(int j = position + 1; j < arr.length; j++){
                    if(arr[j]){
                        flag = true;
                        position = j;
                        break;
                    }
                }
                
                if(!flag){
                    for(int j = position - 1; j >= 0; j--){
                        if(arr[j]){
                            position = j;
                            break;
                        }
                    }
                }  
            }   
            else {
                position = movePosition(position, move, arr);
                move = 0;
                int num = stack.pop();
                arr[num] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(arr[i]) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
    
    public int movePosition(int position, int move, boolean[] arr){
        if(move > 0){
            for(int i = position + 1; i < arr.length; i++){
                if(move == 0) break;
                if(arr[i]){
                    move--;
                }
                position++;
            }
        }
        else{
            for(int i = position - 1; i >= 0; i--){
                if(move == 0) break;
                if(arr[i]){
                    move++;
                }
                position--;
            }
        }
        return position;
    }
}
