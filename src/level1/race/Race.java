package level1.race;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 : players
// 2. 해설진이 부르면 추월한 것(교환이 일어남) callings 배열
// 3. 목적: 경기가 끝났을 때 선수들의 이름을 등수 순서대로 배열에 담아 return 하는 solution
public class Race {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = sol.solution(players, callings);
        System.out.println(Arrays.toString(result));
    }
}
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int[] calls = new int[callings.length];

        //숫자로 매핑한 뒤 비교 후 결과를 다시 문자열로 매핑
        Map<String, Integer> playermap = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            playermap.put(players[i], i);
        } //매핑

        for(int i = 0; i <= callings.length-1; i++){
            calls[i] = playermap.get(callings[i]);
        } //매핑

        for(String calling : callings){
            int currentPos = playermap.get(calling); // 부른 선수의 위치 값 반환
            String frontPlayer = players[currentPos - 1]; // 부른 선수으 앞 선수

            players[currentPos - 1] = calling; // 부른 선수를 앞 번호로
            players[currentPos] = frontPlayer; // 현재 위치에는 앞 선수를

            playermap.put(calling, currentPos - 1); // map 수정, 부른 선수 위치 앞으로
            playermap.put(frontPlayer, currentPos); // map 수정, 앞 선수 위치는 현재 위치로
        }
        return players;
    }
}

