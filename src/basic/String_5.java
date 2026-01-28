package basic;

public class String_5 {

}
class Solution5{
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];

        for(int i = 0; i <= picture.length-1; i++ ){
            String str = "";
            for(int j = 0; j <= picture[i].length()-1; j++){
                str += String.valueOf(picture[i].charAt(j)).repeat(k);
            }
            for(int j = 0; j <= k-1; j++){
                answer[i * k + j] = str; //배열을 확장시킨 뒤 넣어줘야 함. i * k + j는 맣이 나올듯?
            }
        }
        return answer;
    }
}
