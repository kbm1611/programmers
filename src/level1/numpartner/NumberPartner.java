package level1.numpartner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberPartner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution("100", "2345");
        System.out.println("result = " + result);
    }
}
// X, Y string에 공통으로 나오는 정수들로 만드는 최대값.
// HashMap으로 X, Y를 할까? 아니면 그냥 정수배열로 만들고 그걸 가지고
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        int[] intX = X.chars().map(Character::getNumericValue).toArray();
        int[] intY = Y.chars().map(Character::getNumericValue).toArray();

        System.out.println("intX = " + Arrays.toString(intX));
        System.out.println("intY = " + Arrays.toString(intY));

        for (int x : intX) mapX.put(x, mapX.getOrDefault(x, 0) + 1);
        for (int y : intY) mapY.put(y, mapX.getOrDefault(y, 0) + 1);

        System.out.println("mapX = " + mapX);
        System.out.println("mapY = " + mapY);


        return answer;
    }
}
