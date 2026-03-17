package level1.clawmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClawMachine {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3, 0},
                {0, 2, 5, 0, 1, 2},
                {4, 2, 4, 4, 2, 6},
                {3, 5, 1, 3, 1, 5},
                {2, 9, 8, 1, 4, 7}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4, 5, 6, 6, 2};
        int result = new Solution().solution(board, moves);
        System.out.println("result = " + result);
    }
}
// 인형 뽑기 바구니가 있고 인형을 뽑는 곳이 있다. move = 크레인을 작동시키기 위함(위쪽부터 뽑음)
// 뽑으면 해당 배열의 값 0으로 만들기.
//터트려서 사라진 인형의 개수를 반환
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        List<Stack<Integer>> boards = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            boards.add( new Stack<>() );
        }
        for(int i = 0; i < board.length; i++){
            for(int j = board[i].length - 1 ; j >= 0; j--){
                if(board[j][i] != 0){
                    boards.get(i).push(board[j][i]);
                }
            }
        }

        // move-1 에 해당하는 인덱스의 stack 값을 가져와 비교 연산 진행
        // 자 이제 왜 안되는 지 생각 해보자.. 실패가 생기는 이유를 생각해보자.
        for(int move : moves){
            Stack<Integer> col = boards.get(move-1);
            if(!col.isEmpty()){
                int doll = col.pop();
                System.out.println("doll = " + doll);
                if(basket.isEmpty()){ // 바구니가 비어있으면 바로 인형 추가
                    basket.push(doll);
                }else if(doll == basket.peek()){ //바구니의 마지막 값과 같다면
                    basket.pop();
                    answer += 2;
                }else{ // 마지막 값과 같지 않다면 인형 추가
                    basket.push(doll);
                }
            }
            System.out.println("basket = " + basket);
        }

        return answer;
    }
}
