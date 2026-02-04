package basic;

public class babbling {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String [] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        String [] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        int result = solution8.solution(babbling2);
        System.out.println(result);
    }
}
class Solution8 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woayao", "ma"};
        String notWord1 = "ayaya";
        String notWord2 = "maya";

        for (int i = 0; i <= babbling.length - 1; i++) {
            int whatsize = 0; // 사이즈 초기화

            for (int j = 0; j <= words.length - 1; j++) { //문자 배열 순회
                if ( searchWord(words[j], babbling[i]) ) { //만약 문자가 있다면
                    whatsize += words[j].length(); //해당 단어만큼의 사이즈를 더하고
                }
            }
            if(searchWord(notWord1, babbling[i])){
                continue;
            }else if(searchWord(notWord2, babbling[i])){
                continue;
            }else if (babbling[i].length() == whatsize) { //문장의 길이가 더한 사이즈와 같고
                answer++;
            }
        }
        return answer;

    }
    boolean searchWord(String word, String sentence) {
        if (word.length() > sentence.length()) return false;

        for (int i = 0; i <= sentence.length() - word.length() ; i++) {
            boolean match = true;

            for (int j = 0; j <= word.length() - 1; j++) {
                if (sentence.charAt(i + j) != word.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}


