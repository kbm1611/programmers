package basic;

import java.util.ArrayList;

public class Random_num {
    public static void main(String[] args) {
        Solution7 solu = new Solution7();
        int[] arr = {0,1,1,1,1};
        ArrayList<Integer> result = solu.solution(arr, 4);
        System.out.println(result);
    }
}
class Solution7 {
    public ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();

        int flag = 0;
        for(int i = 0; i <= arr.length-1; i++){
            if(!answer.contains(arr[i]) && flag < k){
                answer.add(arr[i]);
                flag++;
            }
        }

        while (answer.size() < k ){
            answer.add(-1);
        }

        return answer;
    }
}
