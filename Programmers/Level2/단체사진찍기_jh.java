//생각나는 방법이 모든 경우의 수를 다 찾는 방법만 있었다...
//조건 거리가 0인 경우는 두 사람을 하나로 취급해서 하고, 1 이상인 경우는 사이에 하나를 껴서 계산하려고도 했지만
//요즘 느끼는 것은 로직이 엄청 복잡해지거나, 하드 코딩이 들어가면 제대로 된 접근이 아니라는 것이다..
//그래서 그냥 단순하게 모든 경우의 수를 다 찾아서 했다.
class Solution {
    public int answer = 0;
    public void dfs(String[] list, boolean[] visit, String st, int cnt, String[] data){
        if(cnt == 8){
            boolean flag = true;
            for(String c : data){
                int me = st.indexOf(c.charAt(0));
                int you = st.indexOf(c.charAt(2));
                char cond = c.charAt(3);
                
                int condDistance = c.charAt(4) - '0' + 1;
                int dist = Math.abs(me-you);
                
                if(cond == '='){
                    if(condDistance != dist){
                        flag = false;
                        break;
                    }
                        
                }
                else if(cond == '>'){
                    if(dist <= condDistance){
                        flag = false;
                        break;
                    }
                        
                }
                else if(cond == '<'){
                    if(dist >= condDistance){
                        flag = false;
                        break;
                    }
                        
                }
            }
            if(flag) 
                answer += 1;
        }
        else{
            for(int i = 0; i < 8; i++){
                if(visit[i]) continue;
                visit[i] = true;
                String t = st + list[i];
                dfs(list, visit, t, cnt + 1, data);
                visit[i] = false;  
            }
        }
    }
    public int solution(int n, String[] data) {
        //A, C F J, M, N, R, T
        String[] list = new String []{"A","C","F","J","M","N","R","T"};
        boolean[] visit = new boolean[8];
        dfs(list, visit, "", 0, data);
        return answer;
    }
}
