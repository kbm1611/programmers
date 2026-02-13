package basic;

public class Division {
    public static void main(String[] args) {
        Solution13 solu = new Solution13();
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        double result = solu.solution(array);
        System.out.println("result: " + result);
    }
}
class Solution13 {
    public double solution(int[] numbers) {
        double answer = 0;

        double sum = 0;
        for(int i = 0; i <= numbers.length-1; i++){
            sum += numbers[i];
        }
        answer = (double)(sum / numbers.length);
        if(answer % 0.5 == 0){
            return answer;
        }else{
            return (int)answer;
        }
    }
}
