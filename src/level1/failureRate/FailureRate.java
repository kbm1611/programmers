package level1.failureRate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FailureRate {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(5, new int[]{2,1,2,6,2,4,3,3});
        System.out.println("result:" + Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages); //작은 수 -> 큰 수로 정렬 1 2 2 2 3 3 4 6

        //도전한 사람 중 같은 비율만 빼면 됨
        //정렬을 어떻게 해야 원하는대로 정렬이 될 것인가.
        // 애초에 넣을 때 큰 지 비교해서 넣으면 되는 거 아닌가?
        List<Double> temps = new ArrayList<>();
        List<Integer> tempsInt = new ArrayList<>();
        for(int i = 1; i <= N; i++){ //5번 반복
            double num = 0;
            double den = 0;
            for(int j = 0; j <= stages.length-1; j++){
                if(stages[j] >= i) den++; // 도전한 사람
                if(stages[j] == i) num++; // 도전하고 못 깬 사람
            }
            double temp = num / den;
            for(int j = 0; j <= temps.size()-1; j++){ //temps를 계속 확인함
                if(temp > temps.get(j)){ //실패율이 기존 것보다 크다면
                    temps.add(j, temp);
                    tempsInt.add(j, i);
                    break;
                }else if(j == temps.size()-1){ //마지막까지 큰 것이 없다면..
                    temps.add(temp);
                    tempsInt.add(i);
                    break;
                }
            }

            if(i == 1){
                temps.add(temp); //첫 값은 바로 넣기
                tempsInt.add(i);
            }
        }
        return tempsInt.stream().mapToInt(i -> i).toArray();

    }
}
