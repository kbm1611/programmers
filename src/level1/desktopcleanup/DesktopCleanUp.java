package level1.desktopcleanup;

import java.util.Arrays;

public class DesktopCleanUp {
    public static void main(String[] args) {
        int[] result = new Solution().solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."});
        System.out.println("result = " + Arrays.toString(result));
    }
}
// wallpaper : 정사각형 격자판 빈칸 . 파일 있으면 #
// 모든 파일을 한번에 선택할 수 있는 최소한의 시작점좌 끝점 찾아서 배열로 반환하기
// 파일 중 가장 작은 x, 가장 큰 x, 가장 작은 y, 가장 큰 y 에 대해서 가장작은 x,y와 가장큰 x,y를 반환해주면 된다~
class Solution {
    public int[] solution(String[] wallpaper) {
        char[][] wall = new char[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++){
            wall[i] = wallpaper[i].toCharArray();
            System.out.println(Arrays.toString(wall[i]));
        }

        int minX = 50;
        int minY = 50;
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < wall.length; i++){
            for(int j = 0; j < wall[i].length; j++){
                if(wall[i][j] == '#'){
                    if(minX > j) minX = j;
                    if(minY > i) minY = i;
                    if(maxX < j) maxX = j;
                    if(maxY < i) maxY = i;
                }
            }
        }
        System.out.printf("minY = %d, minX = %d, maxY = %d, maxX = %d\n", minY, minX, maxY+1, maxX+1);
        int[] answer = new int[]{minY, minX, maxY+1, maxX+1};
        return answer;
    }
}
