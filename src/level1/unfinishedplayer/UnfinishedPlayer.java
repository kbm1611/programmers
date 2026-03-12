package level1.unfinishedplayer;

import java.util.*;

public class UnfinishedPlayer {
    public static void main(String[] args) {
        String[] parts = {"leo", "kiki", "eden"};
        String[] comple = {"eden", "kiki"};

        Solution sol = new Solution();
        String result = sol.solution(parts, comple);
        System.out.println("result = " + result);
    }
}
// partcipant : 참여자 이름 배열
// completion : 완주한 이름 배열
// completion에 있다면 참여자 이름 배열 -1 저장
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer= "";
        // 이름 순으로 정렬
        Map<String, Integer> partiMap = new HashMap<>();

        for(String player : participant) partiMap.put(player, partiMap.getOrDefault(player, 0) + 1); //동명 이인이 있다면 값을 2로
        for (String player : completion) partiMap.put(player, partiMap.get(player) - 1); //완주한 사람의 값을 0으로 초기화

        for (String key : partiMap.keySet()) {
            if (partiMap.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
