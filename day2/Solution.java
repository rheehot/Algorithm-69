package day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 카카오 신고 결과 받기
 * id_list : 이용자의 ID를 받은 배열
 * report : ["신고한 유저" "신고당한 유저"] 배열
 * k : 신고 횟수에 따른 정지 기준
 * answer : 신고한 유저가 받은 결과메일 갯수 배열
 */
public class Solution {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] answer = solution(id_list, report, k);
        System.out.println(answer);

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();

        int[] answer = new int[id_list.length];

        for (String info : report) {
            String user_reporter = info.split(" ")[0];
            String user_reported = info.split(" ")[1];

            if (reportedUser.containsKey(user_reported)) {
                reportedUser.get(user_reported).add(user_reporter);
            } else {
                reportedUser.put(user_reported, new HashSet<>() {{
                    add(user_reporter);
                }});
                reportedUser.get(user_reported).add(user_reporter);
            }
        }

        for (String user_reported : reportedUser.keySet()) {
            HashSet<String> targetList = reportedUser.get(user_reported);
            if (targetList.size() >= k) {
                Iterator it = targetList.iterator();        // <- *
                while (it.hasNext()) {
                    String userId = (String) it.next();
                    if (result.containsKey(userId)) {
                        result.put(userId, result.get(userId) + 1);
                    } else {
                        result.put(userId, 1);
                    }
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if (result.get(id_list[i]) == null) {
                answer[i] = 0;
            } else {
                answer[i] = result.get(id_list[i]);
            }
        }

        return answer;
    }
}
