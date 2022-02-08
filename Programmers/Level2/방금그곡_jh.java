class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
    
        
        for(String music : musicinfos){
            String[] mu = music.split(",");
            String st = mu[0];
            String end = mu[1];
            String song = mu[2];
            String melody = mu[3];
            
            melody = melody.replace("C#", "c");
            melody = melody.replace("D#", "d");
            melody = melody.replace("F#", "f");
            melody = melody.replace("G#", "g");
            melody = melody.replace("A#", "a");
            
            int length = melody.length();
            
            int stHour = Integer.parseInt(st.substring(0,2));
            int stMin = Integer.parseInt(st.substring(3,5));
            
            int endHour = Integer.parseInt(end.substring(0,2));
            int endMin = Integer.parseInt(end.substring(3,5));
            
            int total = 0;
            if(stMin > endMin){
                //12 : 50 / 1 : 5
                total = (endHour - stHour - 1) * 60 + 60 + endMin - stMin;
            }
            else{
                total = (endHour - stHour) * 60 + endMin - stMin;
            }
            
            if(total < m.length()) continue;
            
            int repeat = total / melody.length();
            int namuji = total % melody.length();
            
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < repeat; i++){
                sb.append(melody);
            }
            sb.append(melody.substring(0, namuji));
            System.out.println(sb.toString());
            
            if(sb.toString().contains(m)){
                System.out.println(song);
            }
                
        }
        return answer;
    }
}
