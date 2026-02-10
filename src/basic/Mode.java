package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mode {
    public static void main(String[] args) {
        Solution12 solu = new Solution12();
        int[] array = {0,0,999,999,999};
        int result = solu.solution(array);
        System.out.println("result:" + result);
    }
}
class Solution12 {
    public int solution(int[] array) {
        int[] count = new int[array.length];
        int[] copyArray = new int[array.length];
        for(int i = 0; i <= array.length-1; i++){
            copyArray[i] = -1;
        }
        System.out.println("초기copyArray: "+Arrays.toString(copyArray));

        int flag = 0;
        for(int i = 0; i <= array.length-1; i++){
            for(int k = 0; k <= array.length-1;k++){
                if( copyArray[k] == array[i] ){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                for(int j = 0; j <= array.length-1; j++){
                    if( j == 0 ){
                        copyArray[i] = array[i];
                    }
                    if(array[i] == array[j]){
                        count[i]++;
                    }
                }
            }else{
                count[i] = -1;
                copyArray[i] = -1;
                flag = 0;
            }
        }
        System.out.println("연산 후 count:" + Arrays.toString(count));
        System.out.println("연산 후 array:" + Arrays.toString(array));
        System.out.println("연산 후 copyArray:" + Arrays.toString(copyArray));

        int max = 0;
        for(int i = 0; i <= count.length-1; i++){
            if( max < count[i] ){
                max = count[i];
            }
        }
        int c = 0;
        int maxIndex = 0;
        for(int i = 0; i <= count.length-1; i++){
            if(max == count[i]){
                c++;
                maxIndex = array[i];
            }
        }
        System.out.println("c: " + c);
        if( c >= 2){
            return -1;
        }else{
            return maxIndex;
        }
    }
}
