package level1.workoutCloth;

import java.util.*;

public class WorkOutCloth {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(10, new int[]{1,3,5}, new int[]{2,4,8});
        System.out.println("result = " + result);
    }
}
// 전체 학생수 n, 잃어버린 아이들의 번호 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
// 탐욕법 최대가 되는 return값을 찾아라. 양 옆에만 빌려줄 수 있음.
// 최대치 n에서 lost와 reserve가 적절히 섞여 나온 배열의 크기를 빼면 되는 일.
// 조건1. lost 배열의 양 옆(-1, +1)에 빌려 줄 수 있는 사람이 있는가? 없다면 lostCnt++
// 조건2. oneCnt가 2 이상이면 1을 빼야하나?
//문제 상황을 적어보자
// 문제 조건을 항상 적고 시작하자... 아오
// 도난 당한 사람이
// 1 2  4  6  8         3  7  10  11 12 13
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 빌려준 사람과 잃어버린 사람이 일치할 경우(빌려 줄 수 없음)
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }

        int count = 0;
        // 빌려주면 lostMap에서 없애기, 해쉬 맵으로 만들어야 하나? 인덱스, 값 으로
        for(int i = 0; i < reserve.length; i++){
            // 이미 자기 옷을 입었거나 남에게 빌려준 사람은 건너뛰기
            if(reserve[i] == -1) continue;

            for(int j = 0; j < lost.length; j++){
                //이미 빌린 학생은 건너뛰기
                if(lost[j] == -1) continue;

                if(reserve[i] - 1 == lost[j] || reserve[i] + 1 == lost[j]){
                    lost[j] = -1;
                    reserve[i] = -1;
                    count++;
                    break;
                }
            }
        }

        int realLost = 0;
        for (int l : lost) {
            if (l != -1) realLost++;
        }

        //전체 인원수에서 못 빌린 사람 뺀 값 리턴
        return n - realLost;
    }
}
