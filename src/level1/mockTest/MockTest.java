package level1.mockTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        Solution sol = new Solution();
        int[] result = sol.solution(answers);

        System.out.println(Arrays.toString(result) );
    }
}

// 모든 사람이 찍는 방식이 틀림
// 1번 수포자 : 12345 12345
// 2번 수포자 : 2 1 2 3 2 4 2 5
// 3번 수포자 : 33 11 22 44 55
// answer배열이 주어졌을 때 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
class Solution {
    public int[] solution(int[] answers) {
        //수포자들 배열 생성
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] counts = new int[3];

        //순환 구조에 대하여 count하는 방법
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) counts[0]++;
            if (answers[i] == p2[i % p2.length]) counts[1]++;
            if (answers[i] == p3[i % p3.length]) counts[2]++;
        }

        int max = Math.max(counts[0], Math.max(counts[1], counts[2]));

        List<Integer> list = new ArrayList<>();
        if (max == counts[0]) list.add(1);
        if (max == counts[1]) list.add(2);
        if (max == counts[2]) list.add(3);

        // ArrayList를 다시 배열로
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}