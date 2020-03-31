package medium;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
        地图分析
        你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，
        1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
        我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 
        |x0 - x1| + |y0 - y1| 。
        如果我们的地图上只有陆地或者海洋，请返回 -1。

        一开始，我们找出所有陆地格子，将它们放入队列，作为第 0 层的结点。
        然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
        当遍历结束时，当前的遍历层数就是海洋格子到陆地格子的最远距离。
        注意：为了在遍历中不重复访问海洋格子，我们将已经遍历过的海洋格子的值改为 2，和原来海洋格子里的 0 区别开来。

     */
public class Solution3 {
        public int maxDistance(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){
                        queue.add(new int[]{i,j});
                    }
                }
            }
            if(queue.isEmpty()||queue.size() == m*n){
                return -1;
            }
            int distance = -1;
            while (!queue.isEmpty()){
                int q = queue.size();
                distance++;
                // 这里一口气取出 n 个结点，以实现层序遍历
                for (int i = 0; i < q; i++) {
                    int[] cell = queue.poll();
                    int r = cell[0];
                    int c = cell[1];
                    //遍历上方表格
                    if(r-1 >= 0 && grid[r-1][c]==0){
                        grid[r-1][c] = 2;
                        queue.add(new int[]{r-1,c});
                    }
                    //遍历下方表格
                    if(r+1 < m && grid[r+1][c]==0){
                        grid[r+1][c] = 2;
                        queue.add(new int[]{r+1,c});
                    }
                    //遍历左方表格
                    if(c-1 >= 0 && grid[r][c-1]==0){
                        grid[r][c-1] = 2;
                        queue.add(new int[]{r,c-1});
                    }
                    //遍历右方表格
                    if(c+1 < n && grid[r][c+1]==0){
                        grid[r][c+1] = 2;
                        queue.add(new int[]{r,c+1});
                    }
                }
            }
            return distance;

        }

        public static void main(String[] args) {
            Solution3 s = new Solution3();
            int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
            System.out.println(s.maxDistance(grid));

        }
}
