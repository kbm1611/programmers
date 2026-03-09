package level1.fruitseller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//과일장수
public class FruitSeller {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(4, 3, new int[]{4,1,2,2,4,4,4,4,1,2,4,2});
        System.out.println("result = " + result);
    }
}
// box.size = m
// box의 최대 점수 = 최소점수들 * m을 score에 더함. 해당 box에 넣은 값들은 뺌.
class Solution {
    public int solution(int k, int m, int[] score) {
        int profit = 0;
        int count = 0;

        for(int i = k; i > 0; i--){
            for(int j = 0; j <= score.length-1; j++){
                if(i == score[j]) count++;
                if(count == m){
                    profit += (i * m);
                    count = 0;
                }
            }
        }

        return profit;
    }
}