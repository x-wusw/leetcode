package medium;

/**
 * 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * 解题思路 dp-动态规划
 * dp[i][j] = dp[i-1][j]+dp[i][j-coin[i]]
 *
 * dp[i][j]结果数组
 * coin数组为硬币种类数组
 * i为种类
 * j为金币金额
 */
public class Solution22 {
    public static void main(String[] args) {
        Solution22 s = new Solution22();
        System.out.println(s.waysToChange(5));
        System.out.println(s.simple(5));
    }
    private int waysToChange(int n){
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[4][n+1];
        int[] coin = {1,5,10,25};
        for (int i = 0; i <= n ; i++) {
            dp[0][i] = 1;   //硬币为1时只有一种情况
        }
        for (int i = 1; i < coin.length; i++) {
            dp[i][0] = 1;   //金额为0
        }
        for (int i = 1; i < coin.length; i++) {
            for (int j = 1; j <= n ; j++) {
                if(j>=coin[i]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[3][n];
    }
    //简化为一维数组
    private int simple(int n){
        if(n == 0){
            return 0;
        }
        int[] coin = {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1; //金额为0
        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j <= n ; j++) {
                if(j >= coin[i]){
                    dp[j] = dp[j]+dp[j-coin[i]];
                }
            }

        }
        return dp[n];
    }
}
