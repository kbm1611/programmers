package level1.calday;

public class Calday {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println( sol.solution(5, 24) );
    }
}
// a = 월, b = 일 일때 2016년에 a월 b일은 무슨 요일? ( 2016년 1월 1일은 금요일)
class Solution{
    public String solution(int a, int b){
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 날짜 저장
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int allDay = 0;
        for(int i = 0; i <= a - 2; i++){
            allDay += month[i];
        } //월에 해당하는 달만큼 추가

        allDay += b; //일 추가
        System.out.println("allDay = " + allDay);
        return day[(allDay + 4) % 7];
    }
}
