package medium;
/*
    生命游戏
    给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），
    或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
        如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
        根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的
        每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 */
public class Solution6 {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }
        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] b = new int[][]{{0,1,0,0},{0,1,0,1},{1,0,1,1},{1,0,0,0}};
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===================");
        Solution6 s = new Solution6();
        s.gameOfLife(b);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
}
