package level1.dartgame;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String str1 = "1S2D*3T";
        String str2 = "1D2S#10S";
        String str3 = "1S*2T*3S";
        String str4 = "1T2D3D#";
        String str5 = "1D2S3T*";
        int result = sol.solution(str4);
        System.out.println("result = " + result);
    }
}
// 총3 번의 기회 0~10점 가능
// S, D, T 영역 존재 1제곱 2제곱 3제곱으로 계산
// 스타상, 아차상 -> 스타상 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만듬. 아차상 당첨 시 해당 점수는 마이너스됨.

// S, D, T 를 찾으면 인덱스 -1에 일반, 제곱, 세제곱 시킴
// 먼저 *, #에 따라 나누어버린다.
// S D T에 따라 나누어버린다.
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] dart = dartResult.split("(?<=[SDT*#])(?=[0-9])");
        System.out.println(Arrays.toString(dart));
        
        int[] effects = new int[dart.length]; // *, # 효과 처리 배열
        int[] numbers = new int[dart.length]; // 숫자 배열

        Arrays.fill(effects, 1);

        // effect 배열 만들기
        for(int i = 0; i <= dart.length-1; i++){
            if(dart[i].charAt(dart[i].length()-1) == '*'){
                if(i > 0){ // 앞앞과 앞이 있음.
                    effects[i-1] *= 2;
                    effects[i] *= 2;
                }else{
                    effects[i] *= 2;
                }
                dart[i] = dart[i].replace("*", "");
            }else if(dart[i].charAt(dart[i].length()-1) == '#'){
                effects[i] *= -1;
                dart[i] = dart[i].replace("#", "");
            }
        }
        System.out.println(Arrays.toString(effects));

        for(int i = 0; i <= dart.length-1; i++){
            char ch = dart[i].charAt(dart[i].length()-1); // S,D,T
            int num = Integer.parseInt(dart[i].replaceAll("[^0-9]", ""));
            System.out.println(ch);
            if(ch == 'S'){
                numbers[i] = num;
            }else if(ch == 'D'){
                numbers[i] = (int)Math.pow(num, 2);
            }else if(ch == 'T'){
                numbers[i] = (int)Math.pow(num, 3);
            }
        }

        //최종적으로 effect와 number를 적용한 값들 더하기
        for(int i = 0; i <= numbers.length-1; i++){
            answer += numbers[i] * effects[i];
        }

        return answer;
    }
}
