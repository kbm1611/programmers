package basic;

import java.util.Arrays;

public class Zero_FiveInt {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] result = s1.solution(5, 555);
        System.out.println("result = " + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(int l, int r) {
        int size = 0;
        // 1. 크기 먼저 측정 (조건문이 양쪽 다 똑같아야 ArrayIndexOut이 안 납니다!)
        for (int i = l; i <= r; i++) {
            if (checkZeroFive(i)) size++;
        }

        if (size == 0) return new int[]{-1};

        int[] answer = new int[size];
        int cnt = 0;
        // 2. 배열 채우기
        for (int i = l; i <= r; i++) {
            if (checkZeroFive(i)) {
                answer[cnt++] = i;
            }
        }
        return answer;
    }

    // 문자열 없이 숫자 연산만 사용하는 함수
    private boolean checkZeroFive(int num) {
        // 0은 문제 조건(5 이상)에 따라 들어오지 않겠지만, 기본적으로 포함된다면 true
        if (num == 0) return true;

        while (num > 0) {
            int digit = num % 10; // 마지막 자릿수 추출

            // 0도 아니고 5도 아니면 바로 false 반환
            if (digit != 0 && digit != 5) {
                return false;
            }

            num /= 10; // 다음 자릿수로 이동 (10으로 나눈 몫)
        }
        return true; // 모든 자릿수가 0 또는 5였다면 true
    }
}