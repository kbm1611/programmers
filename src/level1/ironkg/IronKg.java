package level1.ironkg;

import java.util.Arrays;

public class IronKg {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(10, 3, 2);
        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            if(factorCount(i) > limit){
                answer += power;
            }else{
                answer += factorCount(i);
            }
        }
        return answer;
    }

    //자신의 약수의 개수를 알아내는 함수
    public int factorCount(int number){
        int count = 0;
        for(int i = 1; i * i <= number; i++) {
        if(i * i == number){
            count++;
        } else if( number % i == 0){
                count += 2;
            }
        }
        return count;
    }
}
