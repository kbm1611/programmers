package level1.newid;

public class NewId {
    public static void main(String[] args) {
        String str1 = "...!@BaT#*..y.abcdefghijklm";
        String str2 = 	"z-+.^.";
        String str3 = "=.=";
        String str4 = "123_.def";
        String str5 = "abcdefghijklmn.p";
        String result = new Solution().solution(str2);
        System.out.println("result = " + result);
    }
}
// 7단계를 거쳐 설명
// 1단계: 모든 대문자를 대응되는 소문자로 치환
// 2단계: 알파벳 소문자, 숫자(0-9), 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제외
// 3단계: 마침표가 2번 이상 연속된 부분을 하나의 마침표로
// 4단계: 마침표가 처음이나 끝에 위치한다면 제거
// 5단계: 빈문자열이라면 a대입
// 6단계: 16자 이상이면 첫 15문자 제외한 모든 문자 제거, 제거 후 마침표가 new_id 끝에 있다면 마침표도 제거
// 7단계: new_id의 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될때까지 반복해서 끝에 붙임
class Solution {
    public String solution(String new_id) {

        //1단계
        new_id = new_id.toLowerCase();
        System.out.println("1] new_id = " + new_id);

        //2단계 (정규 표현식 공부!)
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");
        System.out.println("2] new_id = " + new_id);

        //3단계
        new_id = new_id.replaceAll("[.]{2,}",".");
        System.out.println("3] new_id = " + new_id);

        //4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        System.out.println("4] new_id = " + new_id);

        //5단계
        if(new_id.isBlank()) new_id = "a";
        System.out.println("5] new_id = " + new_id);

        //6단계
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        System.out.println("6] new_id = " + new_id);

        //7단계
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        System.out.println("7] new_id = " + new_id);

        return new_id;
    }
}