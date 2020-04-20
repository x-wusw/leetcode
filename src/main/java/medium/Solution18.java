package medium;


/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution18 {
    private int dfsnumIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int num_island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ++num_island;
                    dfs(grid, i, j);
                }
            }
        }
    return num_island;
    }

    //深度优先遍历，已遍历的岛屿标记为0 时间复杂度O(MN)，其中 M 和 N 分别为行数和列数。
    //空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M N。
    private void dfs(char[][] grid, int r, int c) {
        int rl = grid.length;
        int cl = grid[0].length;
        if (r < 0 || c < 0 || r >= rl || c >= cl || grid[r][c] == '0') {//不在网格内或者不是岛屿
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);

    }


    public static void main(String[] args) {
        Solution18 s = new Solution18();
        char[][] grid = new char[][]{{'1','1','0','1'},{'1','1','0','0'},{'1','1','0','0'},{'0','0','0','1'}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("dfs-->岛屿的数量："+s.dfsnumIslands(grid));
    }
}