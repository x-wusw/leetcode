package medium;

import java.util.Arrays;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 解题思路：DP ,以i，j为正方形的右下角，边长为dp[i][j]，只需找到坐标其左边、上边、左上边的正方形大小
 * 状态转移方程即dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
 *
 * 时间、空间复杂度：O(m*n) m为行数，n为列数
 */
public class Solution30 {
    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        char[][] s1 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        for (int i = 0; i < s1.length; i++) {
            System.out.println(Arrays.toString(s1[i]));
        }
        System.out.println("最大正方形面积为"+solution30.maximalSquare(s1));
    }

    /**
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix[0].length == 0 ||matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxarea = 0;
        int res = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxarea = Math.max(maxarea, dp[i][j]);
                }
            }
        }
        res = maxarea * maxarea;
        return res;
    }
}
