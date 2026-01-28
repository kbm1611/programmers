package basic;

public class Square {
    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        int[][] arr = {
                {572, 22, 37},
                {287, 726, 384},
                {85, 137, 292},
                {487, 13, 876}
        };
        int[][] result = solu.solution(arr);
        for(int i = 0; i <= result.length-1; i++){
            for(int j =0; j <= result[0].length-1; j++){
                System.out.printf("[%d]", result[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
class Solution4 {
    public int[][] solution(int[][] arr) {
        int col = arr.length;
        int row = arr[0].length;
        System.out.printf("col:%d, row:%d\n", col, row);

        int max = 0;
        if(col > row){ // 세로가 더 많다면
            max = col; // 세로값을 가로값에 대입
        }else if(row > col){ // 가로가 더 많다면
            max = row; // 가로값을 세로값에 대입
        }else{
            return arr; //가로와 세로의 길이가 같으므로 그대로 넘겨줌
        }

        int[][] answer = new int[max][max];
        for(int i = 0; i<= col; i++){
            for(int j =0; j <= row; j++){
                if(i < col && j < row) {
                    answer[i][j] = arr[i][j];
                }
            }
        }
        return answer;
    }
}
