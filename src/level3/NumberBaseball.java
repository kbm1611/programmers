package level3;

import java.util.function.Function;

//숫자야구 알고리즘 풀기
public class NumberBaseball {

    public static void main(String[] args) {
        /*조건
          1~9사이 서로 다른 숫자 4개로 이루어진 비밀번호를 맞추는 게임
          1000이상 9999이하 정수를 제출할 수 있는 기회가 총 n번 있으며, 수를 제출할 때마다 비밀번호에 관한 단서가 주어집니다. 이때 제출한 수의 각 자리수에 대해 아래와 같이 판정합니다.
          숫자가 비밀번호에 아예 없으면 OUT, 숫자가 비밀번호에 포함되어 있지만 위치가 틀리면 BALL, 숫자가 비밀번호에 포함되어 있고 위치도 맞으면 STRIKE*/
        //생각하는 알고리즘 일단 숫자를 입력받겠지 4개를 따로 받을 것인가?

        Function<Integer, String> submit = new Function<Integer, String>() {
            @Override
            public String apply(Integer target) { //타겟번호를 받아 문자열을 반환하는 함수
                int answer = 1234;
                String answerStr = String.valueOf(answer);
                String targetStr = String.valueOf(target);

                int strike = 0;
                int ball = 0;

                for(int i = 0; i < 4 ; i++){ //스트라이크 세는 함수
                    if(answerStr.charAt(i) == targetStr.charAt(i)){
                        strike++;
                    }
                }

                for(int i =0; i < 4; i++){
                    for(int j =0; j < 4; j++){
                        if((answerStr.charAt(i) == targetStr.charAt(j)) && i != j){
                            ball++;
                        }
                    }
                }
                System.out.printf("targetNum: %d, Strike: %d, Ball: %d\n", target, strike, ball);

                if(target == answer){
                    return "4S 0B";
                }
                String str1 = String.valueOf(strike) + "S " + String.valueOf(ball) + "B";
                System.out.println("result = " + str1);
                return str1;
            } //target
        };

        Solution solution = new Solution();
        int finalanswer = solution.solution(3024, submit);
        System.out.println(finalanswer);

    }
}
class Solution{
    public int solution(int n, Function<Integer, String> submit){
        int cnt = 0;
        for(int i = 1000; i <= 9999; i++){
            if(cnt > n) break; //n번 기회 이후 반복문 탈출

            String result = submit.apply(i);
            cnt++;

            if(result.equals("4S 0B")){ cnt++; return i;}
            else if(result.equals("3S 0B")) continue;
            else if(result.equals("3S 1B")) continue;
            else if(result.equals("2S 0B")) continue;
            else if(result.equals("2S 1B")) continue;
            else if(result.equals("2S 2B")) continue;
            else if(result.equals("1S 0B")) continue;
            else if(result.equals("1S 1B")) continue;
            else if(result.equals("1S 2B")) continue;
            else if(result.equals("1S 3B")) continue;
        }
        return 0;
    }
}


//class Solution {
//    public int solution(int n, Function<Integer, String> submit) {
//        // 1000부터 9999까지 반복
//        for (int i = 1000; i <= 9999; i++) {
//
//            // 1. 각 자릿수 분리
//            int num1 = i / 1000;          // 천의 자리
//            int num2 = (i % 1000) / 100;  // 백의 자리
//            int num3 = (i % 100) / 10;    // 십의 자리
//            int num4 = i % 10;            // 일의 자리
//
//            // 2. 정답 조건에 맞지 않는 수는 질문하지 않고 건너뜀
//            // 조건 A: 0이 하나라도 포함되어 있으면 안 됨 (1~9 사이 숫자여야 함)
//            if (num1 == 0 || num2 == 0 || num3 == 0 || num4 == 0) {
//                continue;
//            }
//
//            // 조건 B: 서로 다른 숫자여야 함 (중복 체크)
//            if (num1 == num2 || num1 == num3 || num1 == num4 || num2 == num3 || num2 == num4 || num3 == num4) {
//                continue;
//            }
//
//            // 3. 위 조건을 통과한 '유효한 후보'에 대해서만 submit 호출
//            String result = submit.apply(i);
//
//            // 4. result를 확인하고 소거법 실행.
//
//            // 5. 정답 확인
//            if (result.equals("4S 0B")) {
//                return i;
//            }
//        }
//        return 0;
//    }
//}
