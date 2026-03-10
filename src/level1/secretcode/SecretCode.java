package level1.secretcode;

import java.util.ArrayList;
import java.util.List;

public class SecretCode {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution("aukks", "wbqd", 5);
        System.out.println("result = " + result);
    }
}
// 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
// index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
// skip에 있는 알파벳은 제외하고 건너뜁니다.
// a~z 알파벳 배열 생성 -> skip 문자열에 있는 만큼 제외하여 새로운 배열 생성
// index 만큼 돌리기
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        List<Character> alphabetList = new ArrayList<>();
        for(int i = 'a'; i <= 'z'; i++){
            if(skip.indexOf(i) == -1){
                alphabetList.add((char) i);
            }
        }

        for(int i = 0; i <= s.length()-1; i++){
            char alphabet = s.charAt(i); // a u k k s
            if(alphabetList.contains(alphabet)){
                answer.append(alphabetList.get((alphabetList.indexOf(alphabet) + index) % alphabetList.size()));
            }
        }

        return answer.toString();
    }
}