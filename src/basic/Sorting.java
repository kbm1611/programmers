package basic;

import java.util.ArrayList;

public class Sorting {
    public static void main(String[] args) {
        Solution11 solu = new Solution11();
        int[] array = {1,2,7,10,11};
        int result = solu.solution(array);
        System.out.println("중간값:" + result);
    }
}
class Solution11 {
    public int solution(int[] array) {

        boolean check = true;
        while(check){
            check = sorting(array);
        }
        for(int i = 0; i <= array.length-1; i++){
            System.out.print(array[i]+ " ");
        }
        int answer = array[(Integer)(array.length / 2)];
        return answer;
    }
    public boolean sorting(int[] array){
        int temp = 0;
        int flag = 0;

        for(int i =0; i <= array.length-2; i++){
            if(array[i] < array[i+1]){
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                flag = 1;
            }
        }
        if(flag == 0) return false;
        else return true;
    }
}
