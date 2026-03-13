package level1.numpartner;

public class NumberPartner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution("100", "203045");
        System.out.println("result = " + result);
    }
}
// X, Y string에 공통으로 나오는 정수들로 만드는 최대값.
// HashMap으로 X, Y를 할까? 아니면 그냥 정수배열로 만들고 그걸 가지고
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) countX[c - '0']++;
        for (char c : Y.toCharArray()) countY[c - '0']++;

        int count = 0;
        for(int i = 9; i >= 0; i--){
            count = 0;
            if(countX[i] != 0 && countY[i] != 0) count = Math.min(countX[i], countY[i]);
            System.out.println(i + " count = " + count + "answer = " + answer);
            if(count != 0){
                if( i == 0 && answer.isEmpty()){
                    answer.append(0);
                    break;
                }else{
                    for(int j = 1; j <= count; j++){
                        answer.append(i);
                    }
                }
            }
        }
        System.out.println("answer = " + answer);

        if(answer.isEmpty()) answer.append(-1);

        return answer.toString();
    }
}
