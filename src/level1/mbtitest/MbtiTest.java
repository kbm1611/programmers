package level1.mbtitest;

public class MbtiTest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution( new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5,3,2,7,5} );
    }
}
// 1번: 라이언형(R), 튜브형(T)    2번: 콘형(c), 프로도형(F)    3번: 제이지형(J), 무지형(M)     4번: 어피치형(A), 네오형(N)
// 16가지 중 하나가 나옴, 검사지에는 n 개의 질문이 있고 각 질문에 7개의 선택지
// 0~2 -> 네오형 3점, 3 = 점수x 4~6 : 어피치형 3점
// 만약 얻은 점수가 같으면 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단함.
// survey의 2글자 중 첫번째 글자는 비동의(0~2번 인덱스)
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        // chice배열을 보고 해당하는 값 5면 해당 값들 AN이면  n쪽으로 +1
        // Choice가 4가 아닐 때 첫번째 인덱스가 A면 ~ N면 ~ / C면 ~ F면 ~ / M면 ~ J면 ~
        // Choice가 4이상인지 4이하인지 확인하기
        // 첫번째 값이 A면 choice 값이 1~3이면 mbti++ or chice값이 5~7이면 mbti--
        // 4개 배열로 만들어서 해당하는 숫자 + - 하면 될듯? +면 라이언 -면 튜브형으로
        int[] mbti = new int[4];

        for(int i = 0; i < choices.length; i++){
            char survey1 = survey[i].charAt(0);
            if(choices[i] < 4){
                int score = switch (survey1){
                    case 'R', 'T' -> 0;
                    case 'C', 'F' -> 1;
                    case 'J', 'M' -> 2;
                    case 'A', 'N' -> 3;
                    default -> -1;
                };
            }else if(choices[i] > 4){
            }
        }

        return answer;
    }
}
