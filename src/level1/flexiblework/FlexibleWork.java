package level1.flexiblework;

import java.util.Arrays;

public class FlexibleWork {
    public static void main(String[] args) {
        // 테스트 케이스 1: 금요일 시작, 모든 직원 통과 (입출력 예 #1)
        int[] schedules1 = {700, 800, 1100};
        int[][] timelogs1 = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday1 = 5;
// 정답: 3

// 테스트 케이스 2: 월요일 시작, 시간 보정(55분+10분) 테스트
        int[] schedules2 = {1055};
        int[][] timelogs2 = {
                {1105, 1105, 1105, 1105, 1105, 2300, 2300} // 평일 11:05까지 인정, 주말은 지각 무관
        };
        int startday2 = 1;
// 정답: 1 (1055 + 10 = 1105이므로 지각 아님)

// 테스트 케이스 3: 일요일 시작 (인덱스 음수 체크용)
        int[] schedules3 = {900};
        int[][] timelogs3 = {
                {2359, 910, 910, 911, 910, 910, 2359} // j=0(일), j=6(토)은 지각해도 됨
        };
        int startday3 = 7;
// 정답: 0 (j=3인 수요일에 911로 지각함)

// 테스트 케이스 4: 경계값 테스트 (딱 10분 늦은 경우)
        int[] schedules4 = {800};
        int[][] timelogs4 = {
                {810, 810, 810, 810, 810, 810, 810}
        };
        int startday4 = 1;
// 정답: 1 (810까지는 세이프)
        
        Solution solution = new Solution();
        int result1 = solution.solution(schedules1, timelogs1, startday1);
        System.out.println("result1 = " + result1); // 정답 3
        int result2 = solution.solution(schedules2, timelogs2, startday2);
        System.out.println("result2 = " + result2); // 정답1
        int result3 = solution.solution(schedules3, timelogs3, startday3);
        System.out.println("result3 = " + result3); // 정답 0
        int result4 = solution.solution(schedules4, timelogs4, startday4);
        System.out.println("result4 = " + result4); // 정답 1
    }
}
// 조건1. 휴일에 출근시간은 이벤트에 영향x, 일주일 진행
// 조건2. 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현됨(12:43 -> 1243, 09:30 -> 930)
// 조건3. schedules : 직원n명이 설정한 출근 희망 시각을 담은 1차원 정수배열, timelogs: 일주일 동안 출근한 시각, startday: 시작한 요일
// 조건4. 700 <= schedules <= 1100, 600 <= timelogs <= 2359, startday의 1은 월요일 2는 화요일
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0; //이벤트를 받을 직원의 수
        //희망시간 커트라인 저장
        for(int i = 0; i <= schedules.length-1; i++){
            int hopetime = schedules[i];
            if( (hopetime % 100) >= 50){
                hopetime += 50;
            }else{
                hopetime += 10;
            }
            schedules[i] = hopetime;
        }
        System.out.println("hopetimes:"+Arrays.toString(schedules));
        for(int i = 0; i <= timelogs.length-1; i++){
            System.out.println("timelogs:"+Arrays.toString(timelogs[i]));
        }

        for(int i = 0; i <= timelogs.length -1; i++){
            int cnt = 0;
            for(int j = 0; j <= timelogs[i].length -1; j++){
                int day = (startday + j - 1) % 7 + 1;
                if( day == 6 || day == 7 ){ //토요일 일요일인 경우
                    continue;
                }
                if(schedules[i] >= timelogs[i][j]){
                    cnt++;
                }
            }
            if(cnt == 5){
                answer++;
            }
        }

        return answer;
    }
}
