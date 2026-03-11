package level1.workoutCloth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
// 1 2  4  6  8         3  7  10  11 12 13
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] ishasReserve = new int[n+1];
        for(int i = 0; i <= reserve.length-1; i++){
            if(reserve[i] == 1){
                ishasReserve[reserve[i]+1]++;
            }else if(reserve[i] == n){
                ishasReserve[reserve[i]-1]++;
            }else{
                ishasReserve[reserve[i]-1]++;
                ishasReserve[reserve[i]+1]++;
            }
        }

        int oneCnt = 0; // 1개 인 것
        int twoCnt = 0; // 2개 인 것
        int ReserveCnt = 0;
        for(int i = 0; i <= lost.length-1; i++){
            if(ishasReserve[lost[i]] == 1) oneCnt++;
            else if(ishasReserve[lost[i]] == 2) twoCnt++;
        }
        //실제로 빌려줄 수 있는 사람 카운트
        for(int i = 0; i <= reserve.length-1; i++){
            for(int j = 0; j <= lost.length-1; j++){
                if(reserve[i] - 1 == lost[j]){
                    ReserveCnt++;
                    break;
                }
                else if(reserve[i] + 1 == lost[j]){
                    ReserveCnt++;
                    break;
                }
            }
        }
        // 1 3  6 8     2 7 9   10  11 12
        if(oneCnt % 2 == 0) oneCnt--;
        int hasCnt = oneCnt + twoCnt;
        System.out.println("hasCnt = " + hasCnt);
        System.out.println("ReserveCnt = " + ReserveCnt);
        int Cnt = Math.min(hasCnt, ReserveCnt);
        answer = n - lost.length + Cnt;

        return answer;
    }
}
