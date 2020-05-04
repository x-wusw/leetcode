package simple;

/**
 * 最大字串和
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 s = new Solution11();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
    }
    private int maxSubArray(int[] nums) {
        if(nums.length < 1 && nums == null){
            return 0;
        }
        int len = nums.length;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if(sum < 0){
                sum = 0;
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
