package basic;

public class Rank {
    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        int[] rank = {1,2,3};
        boolean[] attendance = {true, true, true};
        int result = solu.solution(rank, attendance);
        System.out.println("result = " + result);
    }
}
class Solution3 {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] choice = {100, 100, 100};
        int[] idx = new int[3];

        for(int i = 0; i <= rank.length-1; i++){ // 첫번째 가장 큰 값 구하기
            if(attendance[i]) { //해당하는 참석여부가 true일 때
                if(rank[i] < choice[0]){
                    choice[0] = rank[i];
                }
            }
        }
        for(int i = 0; i <= rank.length-1; i++){ // 두번째 가장 큰 값 구하기
            if(attendance[i]) { //해당하는 참석여부가 true일 때
                if(rank[i] < choice[1] && rank[i] != choice[0]){ //첫번째 값 제외
                    choice[1] = rank[i];
                }
            }
        }
        for(int i = 0; i <= rank.length-1; i++){ // 세번째 가장 큰 값 구하기
            if(attendance[i]) { //해당하는 참석여부가 true일 때
                if(rank[i] < choice[2] && rank[i] != choice[1] && rank[i] != choice[0]){ //첫번째, 두번째 값 제외
                    choice[2] = rank[i];
                }
            }
        }
        for(int i = 0; i <= rank.length-1;i++){
            if(choice[0] == rank[i]){
                idx[0] = i;
            }else if(choice[1] == rank[i]){
                idx[1] = i;
            }else if(choice[2] == rank[i]){
                idx[2] = i;
            }
        }
        answer = idx[0] * 10000 + idx[1] * 100 + idx[2];
        return answer;
    }
}
