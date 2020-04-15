package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
    01矩阵
    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
    两个相邻元素间的距离为 1 。
 */
public class Solution15 {

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[][] a = s.updateMatrix1(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 第一种 bfs解法
     * @param matrix
     * @return
     * 每个点入队出队一次，所以时间复杂度：O(n∗m)
     * 虽然我们是直接原地修改的原输入数组来存储结果，但最差的情况下即全都是0时，需要把m∗n个0都入队，
     * 因此空间复杂度是 O(n∗m)
     */
    public int[][] updateMatrix(int[][] matrix){
        //将矩阵中的0全部入队，1设置为-1表示未访问
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else {
                    matrix[i][j] = -1;
                }
            }
        }
        //上下左右四个方向，看邻近四个方向是否被访问到
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                //如果四个邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1){
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }

        return matrix;
    }
    /**
     * 第二种 DP 动态规划
     * 时间复杂度：O(m*n)，其中 m为矩阵行数，n为矩阵列数。计算数组的过程中我们需要遍历三次矩阵，
     * 因此时间复杂度为 O(3*m*n)=O(m*n)。
     * 空间复杂度：O(1)，这里我们只计算额外的空间复杂度。除了答案数组以外，我们只需要常数空间存放若干变量。
     */
    public int[][] updateMatrix1(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 1000;
            }
        }
        //从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i - 1 >= 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + 1);
                }
                if(j - 1 >= 0){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i + 1 < m){
                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j] + 1);
                }
                if(j + 1 < n){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j+1] + 1);
                }
            }
        }
        return dp;
    }
}

