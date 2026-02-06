package basic;

public class incline {
    public static void main(String[] args) {
        Solution9 solu = new Solution9();
        int[][] dots1 = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int[][] dots2 = {{3,5}, {4,1},{2,4},{5,10} };
        int result = solu.solution(dots2);
        System.out.println(result);
    }
}
class Solution9 {
    public int solution(int[][] dots) {

        double incline1;
        double incline2;
        for(int i = 0; i <= dots.length-1; i++){
            if(i == 0){
                incline1 = incline(dots[i], dots[i+1]); // 1,2
                incline2 = incline(dots[i+2], dots[i+3]); // 3,4
                if(incline1 == incline2) return 1;
            }else if(i == 1){
                incline1 = incline(dots[i], dots[i+1]); // 2,3
                incline2 = incline(dots[i-1], dots[i+2]); // 1,4
                if(incline1 == incline2) return 1;
            }else if(i == 2){
                incline1 = incline(dots[i-2], dots[i]); // 1,3
                incline2 = incline(dots[i-1], dots[i+1]); // 2,4
                if(incline1 == incline2) return 1;
            }else{
                break;
            }
        }
        return 0;
    }
    double incline(int[] dot1, int[] dot2 ){ //기울기를 측정하는 함수
        double isincline = (double)(dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
        return isincline;
    }
}