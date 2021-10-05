import java.util.*;
/*
1시간 - Cheating : X
*/
class Solution {
    static class FileName implements Comparable<FileName> {
        String name;
        int number;
        String tail;
        int idx;
        FileName (String name, int number, String tail, int idx) {
            this.name = name;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }

        public int compareTo(FileName fn) {
            if (this.name.equals(fn.name)) {
                return this.number - fn.number;
            }
            return this.name.compareTo(fn.name);
        }
    }
    public String[] solution(String[] files) {
        ArrayList<FileName> al = new ArrayList<>();

        for (int i=0; i<files.length; i++) {
            int numStartIdx = -1;
            int numEndIdx = files[i].length()-1;

            for (int j=0; j<files[i].length(); j++) {
                if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    numStartIdx = j;
                    break;
                }
            }
            for (int j=numStartIdx+1; j<files[i].length(); j++) {
                if (!(files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9')) {
                    numEndIdx = j-1;
                    break;
                }
            }
            String onlyNum = files[i].substring(numStartIdx, numEndIdx+1);
            String name = files[i].substring(0, numStartIdx);
            String tail = "";
            if (files[i].length() > numEndIdx + 1) {
                tail = files[i].substring(numEndIdx+1, files[i].length());
            }

            int number = Integer.parseInt(onlyNum);

            al.add(new FileName(name.toUpperCase(), number, tail, i));
        }

        Collections.sort(al);

        String[] answer = new String[files.length];
        for (int i=0; i<files.length; i++) {
            FileName fn = al.get(i);
            answer[i] = files[fn.idx];
        }

        return answer;
    }
}