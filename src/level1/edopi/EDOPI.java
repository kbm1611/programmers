package level1.edopi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EDOPI {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 1", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C", "2021.11.01 A", "2022.04.01 A"};

        Solution sol = new Solution();
        int[] result = sol.solution(today, terms, privacies);
        System.out.println("result: " + Arrays.toString(result));
    }
}
// 조건1. 경계값 확인(만약 달이 12 이상일 때 예외처리, 기본 일이 1인 경우)
// 조건2. 날짜들을 하나의 숫자로 바꾸기, 공백 기준 날짜와 약관 종류 구분하기
// 조건3. terms도 구분해서 배열에 저장하기
// 작년으로 갈 경우 예외처리, 유효기간이 12개월 이런 식이 아니라 24개월 이럴 때 예외처리, 리스트처리
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] ValidDate = new int[privacies.length];
        int todays = Integer.parseInt(today.replace(".", "")); // 20220519 붙임

        for(int i = 0; i <= privacies.length-1; i++){
            String[] info = privacies[i].split(" "); //0 -> 날짜, 1-> 약관
            int date = Integer.parseInt(info[0].replace(".", "")); // 20210502
            int year = date / 10000; // 약관 년도
            int month = (date % 10000) / 100; // 약관 월
            int day = ((date % 10000) % 100); // 약관 일
            String infoType = info[1];

            for(int j = 0; j <= terms.length-1; j++){ //약관들 조회
                String termType = terms[j].split(" ")[0]; // ex) A // 약관 타입
                if(infoType.equals(termType)){ // 타입 같은 걸 찾으면
                    int termMonth = Integer.parseInt(terms[j].split(" ")[1]); // ex) 6 // 약관 월
                    int sumMonth = month + termMonth;
                    if( sumMonth % 12 == 0){ //12의 배수라면
                        year = year + (sumMonth / 12) - 1;
                        sumMonth = 12;
                    }else{
                        year = year + (sumMonth / 12);
                        sumMonth %= 12;
                    }
                    if(day == 1){
                        if(sumMonth == 1){ //올해 첫 해면
                            year--;
                            sumMonth = 12;
                            day = 28;
                        }else{
                            sumMonth--;
                            day = 28;
                        }
                    }else{
                        day--;
                    }
                    ValidDate[i] = year * 10000 + sumMonth * 100 + day;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= ValidDate.length-1; i++){
            System.out.printf("오늘 날짜: %d\n", todays);
            System.out.printf("ValidDate[%d]: %d\n", i, ValidDate[i]);
            if(todays >= ValidDate[i]){
                list.add(i);
            }
        }
        System.out.println(list);
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            // 2. char를 숫자로 변환 (문자 '1'의 ASCII 값에서 '0'을 빼면 숫자 1이 됩니다)
            answer[i] = list.get(i);
            answer[i]++;
        }
        return answer;
    }
}
