package level1.lotto;

public class Lotto {
    public static void main(String[] args) {

    }
}

//로또 순위를 정하는 방식 6~2개 번호 일치 여부, 알수 없는 번호는 0이고 1~45 중 6개의 숫자
// 로또 당첨 번호 win_nums, 로또 번호 lottos
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int ZeroCnt = 0;
        int answerCnt = 0;
        for(int i = 0; i <= lottos.length-1; i++){
            for(int j = 0; j <= win_nums.length-1; j++){
                if(lottos[i] == win_nums[j]){
                    answerCnt++;
                    break;
                }
            }
            if(lottos[i] == 0){
                ZeroCnt++;
            }
        }
        // answerCnt = 정답 개수, ZeroCnt == 0의 개수 최악은 answerCnt 그대로, 최선은 ZeroCnt를 answerCnt에 더하는 것
        return new int[]{ 7 - answerCnt - ZeroCnt  == 7 ? 6 : Math.max(7 - (answerCnt+ZeroCnt), 1), Math.min( 7 - answerCnt, 6) };
    }
}
