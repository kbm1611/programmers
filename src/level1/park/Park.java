package level1.park;

import java.util.Arrays;
import java.util.Collections;

public class Park {
    public static void main(String[] args) {
        int[] mats = {3, 7, 2, 4};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}
        };

        Solution sol = new Solution();
        int result = sol.solution(mats, park);
        System.out.println("result: " + result);
    }
}
// [ 알고리즘 조건 ]
//      조건1. 각 열과 행마다의 합을 저장함( 예시에서는 2,2,8,5,5,5 // 1,1,6,4,4,4,3,4) 여기서 연속으로 되면서 가장 큰 값을 찾음
//      조건2. 연속된 flag 값을 세워서 그 값이 계속 있어야 함.

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int minlen = 20;
        int col = park.length;
        int row = park[0].length;
        minlen = Math.min(col, row);
        //빈 자리만 중요하기에 1과 0으로 표시된 int 이중배열 생성
        int[][] parkInt = new int[col][row];

        //배열 복사와 동시에 각 빈자리 합 넣기, 최대값 찾기
        for(int i = 0; i <= col-1; i++){
            for(int j = 0; j <= row-1; j++){
                if(park[i][j].equals("-1")){
                    parkInt[i][j] = 0;
                }else{
                    parkInt[i][j] = 1;
                }
            }
        }


        int repeat = minlen;
        int result;
        //이제 구한 연속된 값에 대하여 열도 반족하는 지 확인
        for (int i = 1; i <= repeat; i++) {
            System.out.println(i + "번째 minlen " + minlen);
            result = getConNum(col, row, minlen, parkInt);
            System.out.println(i + "번째 result: " + result);
            if (result == -1) {
                minlen--; //하나씩 줄이면서 다시 진행
            } else { //리턴된 값이 있다면
                answer = result;
                break;
            }
        }

        //정렬
        mats = Arrays.stream(mats)
                .boxed() //integer로 변환
                .sorted(Collections.reverseOrder())// 정렬
                .mapToInt(Integer::intValue)// int로 변환
                .toArray(); // int 배열로 변환

        System.out.println(Arrays.toString(mats));
        for(int mat : mats){
            if(mat <= answer){
                answer = mat;
                return answer; // mats중 answer과 가장 가까운 큰 값 반환
            }
        }
        return -1; //아무도 통과 못하면 -1 반환
    }

    public int getConNum(int col, int row, int maxConNum, int[][] parkInt){ //row = 8, col = 6

        for(int i = 0; i <= col - maxConNum; i++){
            for(int j = 0; j <= row - maxConNum; j++){
                boolean canPlace = true;

                for (int k = 0; k < maxConNum; k++) {
                    for (int l = 0; l < maxConNum; l++) {
                        if (parkInt[i + k][j + l] != 0) {
                            canPlace = false;
                            break;
                        }
                    }
                    if (!canPlace) break;
                }
                if (canPlace) {
                    return maxConNum;
                }
            }
        }
        return -1; //통과를 못하면
    }
}