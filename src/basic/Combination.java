package basic;

public class Combination {
    public static void main(String[] args) {
        Solution16 solu = new Solution16();
        int result = solu.solution(20, 3);
        System.out.println("result = " + result);
    }
}
class Solution16 {
    public int solution(int balls, int share) {
        // nCr에서 r이 n/2보다 크면 nC(n-r)로 계산하는 것이 효율적입니다.
        if (share > balls / 2) share = balls - share;

        return (int) combination(balls, share);
    }

    private long combination(int n, int r) {
        if (r == 0 || n == r) return 1;
        // nCr = n-1Cr-1 + n-1Cr 성질 이용 (파스칼의 삼각형)
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
