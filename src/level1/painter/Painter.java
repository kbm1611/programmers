package level1.painter;

public class Painter {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(8, 4, new int[]{2,3,6});
        System.out.println("result = " + result);
    }
}
// n미터의 벽, 롤러의 길이는 m, 칠해야하는 section
// section의 길이만큼 칠해지면 break; count1 = 페인트 칠한 회수(답), count2 = section의 길이와 비교
// 처음에 section[0]부터 m까지 칠해버리고 m< section[i] 부터 또 칠하고
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int flag = 0;
        for(int i = 0; i <= section.length-1; i++){
            if(section[i] > flag){
                answer++; //1번 칠함 그 다음 flag는 section[i] + m 보다 커야함
                flag = section[i] + m - 1;
            }
            if(flag > n) break;
        }
        return answer;
    }
}
