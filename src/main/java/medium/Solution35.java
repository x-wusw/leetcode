package medium;


/**
 * 152. 乘积最大子数组
 * 求连续子数组的最大乘积
 */
public class Solution35 {

    /**
     * 动态规划
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    private int maxProduct(int[] nums) {
        if(nums.length < 1 || nums == null){
            return 0;
        }
        int max = nums[0],min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            //同时维护最大值和最小值
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
            //取最大值
            if(max > res ){
                res = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution35 s = new Solution35();
        int[] nums = {0,1,-2,-7,0,3,4,-5,-6};
        System.out.println(s.maxProduct(nums));
    }
}
