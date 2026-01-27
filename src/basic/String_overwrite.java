package basic;

public class String_overwrite {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("Hello World!", "12345", 3);
        System.out.println(result);
    }
}
class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        for(int i = 0; i < s; i++){
            answer += my_string.charAt(i);
        }
        for(int i = 0; i <= overwrite_string.length() - 1; i++){
            answer += overwrite_string.charAt(i);
        }
        for(int i = s+overwrite_string.length(); i <= my_string.length()-1; i++ ){
            answer += my_string.charAt(i);
        }

        return answer;
    }
}