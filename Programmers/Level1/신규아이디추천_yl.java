/*
26분 - Cheating : X
*/
class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            // 2
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }

        }
        new_id = sb.toString();

        // 3
        new_id = new_id.replaceAll("\\.+", "\\.");

        // 4
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1, new_id.length());
        }
        if (new_id.length() > 1 && new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        // 5
        if (new_id.equals("")) {
            new_id = "a";
        }

        // 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }

        // 7
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length()-1);
            }
        }

        return new_id;
    }
  }