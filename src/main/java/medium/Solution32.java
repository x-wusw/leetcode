package medium;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Solution32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.myPow(2,-3));
    }
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = Math.abs(n); i != 0 ; i= i/2) {
            if(i%2==1){
                res*=x;
            }
            x *= x;
        }
        return n < 0 ? 1/res : res;
    }
}
