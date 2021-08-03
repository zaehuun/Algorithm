import java.util.*;
/*
1시간 - Cheating : X
Leave uid1234 이건 split했을 때 len이 3개가 아니라 2개임.. 디버깅하는데 개 오래걸림
문제를 잘 읽자 제발..
*/
class Solution {
    static class Person {
        String user_id;
        String action;
        Person (String user_id, String action) {
            this.user_id = user_id;
            this.action = action;
        }
    }
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<Person> al = new ArrayList<>();

        for (int i=0; i<record.length; i++) {
            String[] recordSplit = record[i].split(" ");

            String action = recordSplit[0];
            String user_id = recordSplit[1];
            String user_name = "";
            if (recordSplit.length == 3) {
                user_name = recordSplit[2];
            }

            if (action.equals("Enter")) {
                hm.put(user_id, user_name);
                al.add(new Person(user_id, action));
            }
            else if (action.equals("Leave")) {
                //hm.remove(hm.get(user_id));
                al.add(new Person(user_id, action));
            }
            else if (action.equals("Change")) {
                hm.put(user_id, user_name);
            }

        }
        answer = new String[al.size()];
        for (int i=0; i<al.size(); i++) {
            Person p = al.get(i);
            if (p.action.equals("Enter")) {
                answer[i] = hm.get(p.user_id)+"님이 들어왔습니다.";
            }
            else if (p.action.equals("Leave")) {
                answer[i] = hm.get(p.user_id)+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}