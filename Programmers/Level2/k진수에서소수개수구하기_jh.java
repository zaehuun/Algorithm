class Solution {
    public boolean isPrime(long n){
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) 
                return false;
        return true;
    }
    public String change(int n, int k){
        String result = "";
        while(n > 0){
            result = n % k + result;
            n /= k;
        }
        return result;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String cvt = change(n,k);
        if(!cvt.contains("0")){
            if(isPrime(Long.parseLong(cvt))) return 1;
        }
        String[] arr = cvt.split("0");

        for(String st : arr){
            if(st.equals("")) continue;
            if(st.equals("1")) continue;
            System.out.println(st);
            if(isPrime(Long.parseLong(st))) answer++;
        }
        return answer;
    }
}
