package level1.splitstring;

public class SplitString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution("abracadabra");
        System.out.println("result = " + result); //분리된 문자열 개수
    }
}
// 주어진 문자열을 받고 첫글자부터 실행
// 첫글자와 다른 글자의 개수가 첫글자의 개수와 똑같아질 때 문자열을 분리함.
class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        char firstChar = ' ';

        for(int i = 0; i <= s.length()-1; i++){
            if(cnt1 == 0 && cnt2 == 0){
                firstChar = s.charAt(i);
                answer++;
            }

            if(firstChar == s.charAt(i)) cnt1++;
            else cnt2++;

            if(cnt1 == cnt2){
                cnt1 = 0;
                cnt2 = 0;
            }
        }
        return answer;
    }
}
