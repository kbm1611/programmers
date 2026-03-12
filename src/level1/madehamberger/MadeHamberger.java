package level1.madehamberger;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MadeHamberger {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.solution(new int[]{2,1,1,2,3,1,2,3,1});
        System.out.println("result = " + result);
    }
}
// 1 - 빵, 2 - 야채, 3 - 고기
// 조건1. 1 - 2 - 3 - 1 순서대로 왔을 때 뺀다. 1개 완성
// 조건2. 빼고 난 뒤에도 있다면 뺀다. 2개 완성
// 알고리즘: 문자열로 만든 뒤 1234이 있는지 확인 있다면 문자열의 그 인덱스부터 +3까지를 없애고 다시 진행
// 임시 배열 4칸짜리를 만들자. ingredient 배열 -> 임시 배열(4칸) 초과 시-> stack에 저장 하다가 임시 배열이 1, 2, 3, 1이 되는 순간 배열 초기화 시키고 stack 첫번째 값을 임시배열에 넣음
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int food : ingredient){
            stack.push(food);
            if(stack.size() >= 4){
                int size = stack.size();
                if(stack.get(size - 4) == 1
                        && stack.get(size - 3) == 2
                        && stack.get(size - 2) == 3
                        && stack.get(size - 1) == 1){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
