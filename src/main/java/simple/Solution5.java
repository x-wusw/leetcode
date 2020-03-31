package simple;
/*
    按摩师
    一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
    给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

    动态规划

 */
public class Solution5 {
    public int massage(int[] nums) {
        int[][] dep = new int[nums.length][2];
        if(nums.length ==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        // dp[i][0]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        dep[0][0] = 0;
        dep[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dep[i][0] = Math.max(dep[i-1][0],dep[i-1][1]);
            dep[i][1] = dep[i-1][0] + nums[i];
        }
        return Math.max(dep[nums.length-1][0],dep[nums.length-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        Solution5 s = new Solution5();
        System.out.println(s.massage(nums));

    }
}
