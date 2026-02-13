package basic;

public class Overlines {
    public static void main(String[] args) {
        Solution14 solu = new Solution14();
        int[][] lines = {
                {-123,2},
                {-100,-98},
                {3,9},
                {4,23}
        };
        int result = solu.solution(lines);
        System.out.println("결과: "+ result);
    }
}
class Solution14 {
    public int solution(int[][] lines) {
        // 1. 정수 중 가장 작은값과 가장 큰 값으로 변수 선언
        int smin = Integer.MAX_VALUE;
        int emax = Integer.MIN_VALUE;

        // 2. 받은 선분 중 가장 작은 값과 가장 큰 값 넣기
        for(int i = 0; i <= lines.length-1; i++){
            if( smin > lines[i][0] ){
                smin = lines[i][0];
            }
            if( emax < lines[i][1] ){
                emax = lines[i][1];
            }
        }

        // 3. 그걸 활용해서 range 범위 정하기
        int[] range = new int[emax - smin];
        System.out.println("range.length = " + range.length);
        System.out.println("smin: " + smin + " emax: " + emax);

        // 4. 선분의 시작점을 0에 맞춤
        for(int i =0; i <= lines.length-1; i++){
            lines[i][0] -= smin;
            lines[i][1] -= smin;
        }

        // 5. 모든 선분에 range에 칠하기
        for(int i = 0; i <= lines.length-1; i++){
            for(int j = 0; j <= lines[i][1] - lines[i][0] -1; j++){
                range[lines[i][0]+j]++;
            }
        }

        // 6. 2이상 겹치는 구간 세고 반환
        int count = 0;
        for(int i = 0; i <= range.length-1; i++){
            if(range[i] >= 2){
                count++;
            }
        }
        return count;
    }
}
