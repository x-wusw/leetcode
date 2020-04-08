package medium;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 *  机器人的运动范围：
 *  地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下
 *  移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 *  因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */
public class Solution9 {
    int m,n,k;
    public int moveCount(int m,int n,int k){
        this.k = k;
        this.m = m;
        this.n = n;
        boolean[][] visit  = new boolean[m][n];
        return dfs(0,0,0,visit);
    }
    //解法一： bfs 时间复杂度：O(mn)
    public int moveCount1(int m, int n, int k) {
        //队列保存坐标
        Queue<int[]> queue=new ArrayDeque<>();
        //标记数组
        boolean[][] visited=new boolean[m][n];
        //广搜
        queue.add(new int[]{0,0});
        int count=0;
        visited[0][0]=true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;
            //向下、向右寻找符合要求的位置入队并标记访问状态
            //不越界 并且 数位和小于等于k 并且 未访问过
            if (poll[0] + 1 < m
                    && sum(poll[0] + 1, poll[1]) <= k
                    &&!visited[poll[0]+1][poll[1]]){
                queue.add(new int[]{poll[0]+1,poll[1]});
                visited[poll[0]+1][poll[1]]=true;
            }
            if (poll[1] + 1 < n
                    && sum(poll[0], poll[1] + 1) <= k
                    &&!visited[poll[0]][poll[1] + 1]){
                queue.add(new int[]{poll[0],poll[1]+1});
                visited[poll[0]][poll[1]+1]=true;
            }
        }
        return count;
    }

    //解法二： dfs
    private int dfs(int i,int j,int sum,boolean[][] visit){
        //如果 坐标越界 或者 数位和大于k 或者 已经访问过，则停止当前方向的深搜
        if(i == m || j == n || sum > k || visit[i][j]){
            return 0;
        }
        visit[i][j] = true;//已访问设为true
        //向下或者向右遍历
        return 1 + dfs(i+1,j,sum(i+1,j),visit) + dfs(i,j+1,sum(i,j+1),visit);
    }

    //计算坐标数位和
    private int sum(int x,int y){
        int ans = 0;
        while (x > 0){
            ans += x % 10;
            x /= 10;
        }
        while (y > 0){
            ans += y % 10;
            y /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution9 s = new Solution9();
        int m = 19, n = 20,k = 10;
        System.out.println("dfs遍历结果:"+s.moveCount(m,n,k));
        System.out.println("bfs遍历结果:"+s.moveCount1(m,n,k));

    }
}
