package level1.walkpark;

import java.util.Arrays;

public class WalkPark {
    public static void main(String[] args) {
        String[] pari = { "SOO", "OXX", "OOO" };
        String[] routes = { "E 2", "S 3", "W 1" };
        Solution sol = new Solution();
        int[] result = sol.solution(pari, routes);
        System.out.println("result = " + Arrays.toString(result));
    }
}

// 조건1. pari배열은 직사각형, S = 시작점, O = 지나갈 수 있는 길, X = 지나갈 수 없는 길
// 조건2. routes는 방향과 거리가 주어진 String 배열 W 1, E 5 이런식
// 조건3. routes를 순회하면서 장애물이 있거나 공원 밖을 벗어나면 명령을 수행하지 않고 진행 후 끝까지 수행 후 위치를 return
class Solution {
    public int[] solution(String[] pari, String[] routes) {
        String[][] parkMap = new String[pari.length][pari[0].length()];
        String[][] commands = new String[routes.length][2];
        for (int i = 0; i <= routes.length - 1; i++) {
            commands[i][0] = routes[i].split(" ")[0]; // N,S,W,E 값이 들어감
            commands[i][1] = routes[i].split(" ")[1]; // 숫자 1~9가 들어감
        }

        // 2차원 배열 생성
        for (int i = 0; i <= pari.length - 1; i++) {
            parkMap[i] = pari[i].split(""); // S, O, X 로 저장
            System.out.println(Arrays.toString(parkMap[i]));
        }
        int[] currentPos = { -1, -1 };

        // 시작 지점 찾기
        boolean flag = true;
        for (int i = 0; i <= parkMap.length - 1; i++) {
            for (int j = 0; j <= parkMap[i].length - 1; j++) {
                if (parkMap[i][j].equals("S")) { // 시작 지점을 찾으면 로직 실행
                    currentPos[0] = i; // 현재 위치를 저장
                    currentPos[1] = j;
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
        }
        System.out.println("시작위치 x : " + currentPos[1] + " y : " + currentPos[0]);

        // 명령 수행
        for (int i = 0; i < commands.length; i++) { // 명령 배열의 크기
            String dir = commands[i][0];
            int move = Integer.parseInt(commands[i][1]);

            // 한 칸씩 검사해서 갈 수 있는지 확인 (이미 작성하신 isGoing 활용)
            if (isGoing(parkMap, currentPos, move, dir)) {
                // 갈 수 있다면 실제 좌표 갱신
                switch (dir) {
                    case "N" -> currentPos[0] -= move;
                    case "S" -> currentPos[0] += move;
                    case "W" -> currentPos[1] -= move;
                    case "E" -> currentPos[1] += move;
                }
            }
            System.out.println(dir + " " + move + " 실행 후 위치: " + Arrays.toString(currentPos));
        }
        return currentPos;
    }

    public boolean isGoing(String[][] parkMap, int[] currentPos, int move, String command) {
        int r = currentPos[0];
        int c = currentPos[1];
        int rows = parkMap.length;
        int cols = parkMap[0].length;

        boolean isWithinBounds = switch (command) {
            case "N" -> (r - move >= 0);
            case "S" -> (r + move < rows);
            case "W" -> (c - move >= 0);
            case "E" -> (c + move < cols);
            default -> false;
        };

        if (!isWithinBounds)
            return false;

        return hasAvoided(parkMap, currentPos, move, command);
    }

    public boolean hasAvoided(String[][] parkMap, int[] currentPos, int move, String command) {
        int dr = 0, dc = 0;

        switch (command) {
            case "N" -> dr = -1;
            case "S" -> dr = 1;
            case "W" -> dc = -1;
            case "E" -> dc = 1;
        }

        for (int m = 1; m <= move; m++) {
            int nextR = currentPos[0] + (dr * m);
            int nextC = currentPos[1] + (dc * m);

            if (parkMap[nextR][nextC].equals("X")) {
                return false;
            }
        }
        return true; // 끝까지 장애물이 없음
    }

}