package medium;

/**
 * 跳跃游戏：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 s = new Solution17();
        int[] num = new int[]{1,1,1,0,2};
        System.out.println(s.canJump1(num));
    }
    //更新该位置能达到的最大值，如果该值大于等于数组长度则能到达反之不能
    public boolean canJump(int[] nums){
        int n = nums.length;
        int l = 0,r = 0;
        for ( ; l <= r; l++) {
            r = Math.max(r,l+nums[l]);
            if(r >= n - 1){
                return true;
            }

        }
        return false;
    }
    //精简版
    private boolean canJump1(int[] nums){
        int k = 0;
        for ( int i = 0; i < nums.length - 1; i++) {
            if(i > k)return false;
            else k = Math.max(i,i+nums[i]);
        }
        return true;
    }
}
