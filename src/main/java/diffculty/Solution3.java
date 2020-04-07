package diffculty;

import java.util.Scanner;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 状态定义：
 * dp[i][j]表示word1的前i个字母转换成word2的前j个字母所使用的最少操作。
 *
 * 状态转移：
 * i指向word1，j指向word2
 * 若当前字母相同，则dp[i][j] = dp[i - 1][j - 1];
 * 否则取增删替三个操作的最小值 + 1， 即:
 * dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
 */
public class Solution3 {
    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
        Solution3 s = new Solution3();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输出word1：");
        String word1 = sc.nextLine();
        System.out.println("请输出word2：");
        String word2 = sc.nextLine();
        System.out.println("最小操作次数："+s.minDistance(word1,word2));
    }
}
