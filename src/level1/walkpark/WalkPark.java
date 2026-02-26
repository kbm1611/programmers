package level1.walkpark;

import java.util.Arrays;

public class WalkPark {
    public static void main(String[] args) {
        String[] park = {"OSO","OXX","OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        Solution sol = new Solution();
        int[] result = sol.solution(park, routes);
        System.out.println("result = " + Arrays.toString(result));
    }
}
// 조건1. park배열은 직사각형, S = 시작점, O = 지나갈 수 있는 길, X = 지나갈 수 없는 길
// 조건2. routes는 방향과 거리가 주어진 String 배열 W 1, E 5 이런식
// 조건3. routes를 순회하면서 장애물이 있거나 공원 밖을 벗어나면 명령을 수행하지 않고 진행 후 끝까지 수행 후 위치를 return
class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[][] parkMap = new String[park.length][park[0].length()];
        String[][] commands = new String[routes.length][2];
        for(int i = 0; i <= routes.length-1; i++){
            commands[i][0] = routes[i].split(" ")[0]; //N,S,W,E 값이 들어감
            commands[i][1] = routes[i].split(" ")[1]; // 숫자 1~9가 들어감
        }

        for(int i = 0; i <= park.length-1; i++){
            parkMap[i] = park[i].split(""); // S, O, X 로 저장
            System.out.println(Arrays.toString(parkMap[i]));
        }
        int[] currentPos = {0,0};
        for(int i = 0; i <= parkMap.length-1; i++){
            for(int j = 0; j <= parkMap[i].length-1; j++){
                if(parkMap[i][j].equals("S")){ //시작 지점을  찾으면 로직 실행
                    currentPos[0] = i; //현재 위치를 저장
                    currentPos[1] = j;
                    for(int k = 0; k <= commands.length-1; k++){ //명령 배열의 크기
                        // 장애물이 있거나 공원에서 벗어나면 안됨 -> 2가지 조건문
                        int move = Integer.parseInt(commands[k][1]);
                        boolean flag = true;
                        switch (commands[k][0]) {
                            case "N" -> {
                                if ((currentPos[0] - move >= 0)) { //맵을 벗어나는지 확인
                                    for (int m = 0; m < move; m++) {
                                        System.out.println("N현재위치값: "+parkMap[currentPos[0] - m][currentPos[1]]);
                                        if (parkMap[currentPos[0] - m][currentPos[1]].equals("X")) { //지나가는 길에 X가 1개라도 있다면
                                            flag = false;
                                            break;
                                        }
                                    }
                                    if( flag ){ // X가 없다면 이동
                                        currentPos[0] -= move;
                                    }
                                }
                            }
                            case "S" -> {
                                if (currentPos[0] + move <= parkMap.length - 1) { //맵을 벗어나는지 확인
                                    for (int m = 0; m < move; m++) {
                                        System.out.println("S현재위치값: "+parkMap[currentPos[0] + m][currentPos[1]]);
                                        if (parkMap[currentPos[0] + m][currentPos[1]].equals("X")) { //지나가는 길에 X가 1개라도 있다면
                                            flag = false;
                                            break;
                                        }
                                    }
                                    if( flag ){ // X가 없다면 이동
                                        currentPos[0] += move;
                                    }
                                }
                            }
                            case "W" -> {
                                if (currentPos[1] - move >= 0) { //맵을 벗어나는지 확인
                                    for (int m = 0; m < move; m++) {
                                        System.out.println("W현재위치값: "+parkMap[currentPos[0]][currentPos[1]-m]);
                                        if (parkMap[currentPos[0]][currentPos[1]-m].equals("X")) { //지나가는 길에 X가 1개라도 있다면
                                            flag = false;
                                            break;
                                        }
                                    }
                                    if( flag ){ // X가 없다면 이동
                                        currentPos[1] -= move;
                                    }
                                }
                            }
                            case "E" -> {
                                if (currentPos[1] + move <= parkMap[i].length - 1) { //맵을 벗어나는지 확인
                                    for (int m = 0; m < move; m++) {
                                        System.out.println("E현재위치값: "+parkMap[currentPos[0]][currentPos[1]+m]);
                                        if (parkMap[currentPos[0]][currentPos[1]+m].equals("X")) { //지나가는 길에 X가 1개라도 있다면
                                            flag = false;
                                            break;
                                        }
                                    }
                                    if( flag ){ // X가 없다면 이동
                                        currentPos[1] += move;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return currentPos; // 현재 위치
    }
}