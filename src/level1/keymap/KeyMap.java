package level1.keymap;

import java.util.*;

public class KeyMap {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new String[]{"AA"}, new String[]{"B"});
    }
}
//kemap : "ABACD" , "BCEFD" // targets: "ABCD", "AABB" // result : [9,4]
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // j값이 적은 것이 효율적인 set에 들어가면 됨.
        Map<Character, Integer> keyHash = new HashMap<>();
        for(int i = 0; i <= keymap.length-1; i++){
            for(int j = 0; j <= keymap[i].length()-1; j++){
                char key = keymap[i].charAt(j);
                if( !keyHash.containsKey(key)){ //아예 없을 경우
                    keyHash.put(key, j+1);
                }else if(keyHash.containsKey(key) && keyHash.get(key) > j+1 ){ //만약 존재하는데 기존 j보다 작을경우
                    keyHash.put(key, j+1);
                }
            }
        }
        System.out.println("keyHash: " + keyHash);

        // 해당 효율표를 바탕으로 targets에 대한 result를 계산

        for(int i = 0; i <= targets.length-1; i++){
            boolean ishasTarget = true;
            int sum = 0;
            for(int j = 0; j <= targets[i].length()-1; j++){
                char key = targets[i].charAt(j);
                if( !keyHash.containsKey(key) ){
                    answer[i] = -1;
                    ishasTarget = false;
                    break;
                } //만약 효율표에 없는 문자가 들어오면 -1 저장
                sum += keyHash.get(key);
            }
            if(ishasTarget) answer[i] = sum;
        }
        System.out.println("answer = " + Arrays.toString(answer));

        return answer;
    }
}
