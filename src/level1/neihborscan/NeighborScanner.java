package level1.neihborscan;

import java.util.Objects;

public class NeighborScanner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"} };
        int result = sol.solution(board, 1, 2);
    }
}
class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for(int i = 0; i <= 3; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n){
                if(board[h][w].equals(board[h_check][w_check])) count++;
            }
        }
        return count;
    }
}
