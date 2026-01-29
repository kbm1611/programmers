package basic;

public class compare1 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        int result = solution.solution("<","=",20,50);
        System.out.println(result);
    }
}
class Solution6 {
    public int solution(String ineq, String eq, int n, int m) {
        String str1 = ineq + eq;
        System.out.println(str1);
        if(str1.equals(">=")){
            return n >= m ? 1 : 0;
        }else if(str1.equals("<=")){
            return n <= m ? 1 : 0;
        }else if(str1.equals(">!")){
            return n > m ? 1 : 0;
        }else if(str1.equals("<!")){
            return n < m ? 1 : 0;
        }
        return 0;
    }
}