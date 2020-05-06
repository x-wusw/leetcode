package medium;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
 * 每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、
 * 第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 * 解题思路：DP
 *  dp(i)=min(dp(j1)+costs[0],dp(j7)+costs[1],dp(j30)+costs[2])
 *  时间复杂度：O(N) N为数组days天数
 *  空间复杂度：O(N1) N1为需要出行的天数
 */
public class Solution29 {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length < 1 || costs == null || days.length < 1){
            return 0;
        }
        int len = days.length;
        //最后一天
        int end = days[len-1];
        int[] dp = new int[end + 1];
        int pos = 0;
        for (int i = 1; i <= end ; i++) {
            if(i == days[pos]){  //记录需要出行的日期
                int n1 = i - 1;
                int n2 = i - 7 > 0 ? i - 7 : 0;
                int n3 = i - 30 > 0 ? i - 30 : 0;
                dp[i] = Math.min(dp[n1]+costs[0],Math.min(dp[n2]+costs[1],dp[n3]+costs[2]));
                pos++;
            }else {               //不需要出行的日子花费为0
                dp[i] = dp[i - 1];
            }
        }
        return dp[end];
    }

    public static void main(String[] args) {
        Solution29 s = new Solution29();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(s.mincostTickets(days,costs));
    }
}
