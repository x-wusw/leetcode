package simple;
/*
     三维形体的表面积
     在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
    每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
    请你返回最终形体的表面积。

 */
public class Solution6 {
    public int surfaceArea(int[][] grid) {
        int len = grid.length;
        int area = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp = grid[i][j];
                if(temp > 0){
                    // 一个柱体中：2个底面 + 所有的正方体都贡献了4个侧表面积
                    area += (temp<<2) + 2;
                    // 减掉 i 与 i-1 相贴的两份表面积
                    area -= i > 0 ? Math.min(temp,grid[i-1][j])<<1 : 0;
                    // 减掉 j 与 j-1 相贴的两份表面积
                    area -= j > 0 ? Math.min(temp,grid[i][j-1])<<1 : 0;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        int[][] grid = new int[][]{{1,2},{3,4}};
        System.out.println(s.surfaceArea(grid));
    }
}
