package basic;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};

        int left = 0;
        int right = arr.length-1;

        for(int index = 0; index < query.length; index++){
            if(index % 2 == 0){
                right = left + query[index];
            }else{
                left = left + query[index];
            }
        }
        int[] answer = new int[right - left + 1];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr[left + i];
        }
        System.out.println(Arrays.toString(answer));
    }
}
