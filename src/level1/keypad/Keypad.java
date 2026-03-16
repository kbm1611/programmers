package level1.keypad;


public class Keypad {
    public static void main(String[] args) {
        String result = new Solution().solution(new int[]{1,3,4,5,8,2,1,4,5,9,5}, "right");
        System.out.println("result = " + result);
    }
}
// numbers에서 147은 왼손 369는 오른손으로 하고 2580은 왼손 오른손 중 가까운 순으로 만약 같다면 hand에 들어간 오른손잡이인지 왼손잡이인지에 따라 다름
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 초기값 설정
        int lPosX = 0;
        int lPosY = 3;
        int rPosX = 2;
        int rPosY = 3;

        int targetX = 0;
        int targetY = 0;

        for (int num : numbers) {
            // target 정하기
            if (num == 0) {
                targetX = 1;
                targetY = 3;
            } else if (num % 3 == 0) {
                targetX = 2;
                targetY = num / 3 - 1;
            } else {
                targetX = num % 3 - 1;
                targetY = num / 3;
            }

            if (num % 3 == 1) { // 1, 4 , 7
                lPosX = targetX;
                lPosY = targetY;
                answer.append('L');
            } else if (num % 3 == 0 && num != 0) { // 3, 6, 9
                rPosX = targetX;
                rPosY = targetY;
                answer.append('R');
            } else { // 2, 5, 8, 0 , 로직이 필요한 곳
                int lD = Math.abs(targetX - lPosX) + Math.abs(targetY - lPosY);
                int rD = Math.abs(targetX - rPosX) + Math.abs(targetY - rPosY);

                if (lD < rD) {
                    lPosX = targetX;
                    lPosY = targetY;
                    answer.append('L');
                } else if (lD > rD) {
                    rPosX = targetX;
                    rPosY = targetY;
                    answer.append('R');
                } else if (hand.equals("left")) {
                    lPosX = targetX;
                    lPosY = targetY;
                    answer.append('L');
                } else {
                    rPosX = targetX;
                    rPosY = targetY;
                    answer.append('R');
                }
            }
        }
        return answer.toString();
    }
}