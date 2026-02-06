package basic;

import java.util.ArrayList;

public class Lcm {
    public static void main(String[] args) {
        Solution10 solu = new Solution10();
        int[] result = solu.solution(2, 4, 1, 6);
        System.out.printf("[%d, %d]\n", result[0], result[1]);
    }
}
class Solution10 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int lcm = LCM(denom1, denom2);
        System.out.println("lcm:"+lcm);
        numer1 = numer1 * (lcm / denom1);
        numer2 = numer2 * (lcm / denom2);
        int numer = numer1 + numer2;
        System.out.println("numer: " + numer);

        int maxnum = Math.max(numer, lcm);
        int minnum = Math.min(numer, lcm);

        int factor = 1;
        if(maxnum % minnum == 0){
            numer /= minnum;
            lcm /= minnum;
        }else{
            for(int i = 1; i <= minnum; i++){
                if(maxnum % i == 0 && minnum % i == 0){
                    factor = i;
                }
            }
            numer /= factor;
            lcm /= factor;
        }


        answer[0] = numer;
        answer[1] = lcm;
        return answer;
    }
    //최소 공배수를 찾는 알고리즘! -> 가장 큰 수를 1,2,3,4,5배 하면서 작은 수로 나눠지는 지 확인! 나눠지면 최소공배수
    public int LCM(int denom1, int denom2){
        int max = Math.max(denom1, denom2);
        int min = Math.min(denom1, denom2);
        int cm = 0;
        
        for(int i = 1; i <= min; i++){
            if((max * i) % min == 0){
               cm = max * i;
               break;
            }
        }
        return cm;
    }
}
