package level1.foldbill;

public class FoldBill {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[]{30,15}, new int[]{26,17});
        System.out.println("result = " + result);
    }
}
class Solution{
    public int solution(int[] wallet, int[] bill){
        int answer = 0;
        while(Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1]) || Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1])){
            //지폐의 큰 부분이 월렛의 큰 부분보다 크거나 지폐의 작은 부분이 월렛의 작은 부분보다 크면 계속함.
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}