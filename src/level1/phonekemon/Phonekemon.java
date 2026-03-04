package level1.phonekemon;

import java.util.HashSet;
import java.util.Set;

public class Phonekemon {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = {3,3,3,2,2,2};

        int result = sol.solution(arr);
        System.out.println("result = " + result);
    }
}
class Solution {
    public int solution(int[] nums) {
        Set<Integer> valueSet = new HashSet<>();

        for(int i = 0; i <= nums.length-1; i++){
            valueSet.add(nums[i]);
        }

        return Math.min(valueSet.size(), nums.length / 2);
    }
}
