package diffculty;

/**
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 解决思路：贪心算法 找局部最优解,最后达到全局优先
 */
public class Solution9 {

    public static void main(String[] args) {
        Solution9 s = new Solution9();
        int[] nums = {2,3,1,1,4,1,2,3,1,4};
        System.out.println("正向--最小跳跃数："+s.jump(nums));
        System.out.println("反向--最小跳跃数："+s.jump1(nums));

    }

    /**
     * 贪心算法：正向寻找每一次能到达的最远位置
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private int jump(int[] nums) {
        int len = nums.length - 1;
        int end = 0;
        int maxpos = 0;
        int steps = 0;
        for (int i = 0; i < len; i++) {
            //每一个位置能跳跃到的最园位置
            maxpos = Math.max(maxpos,i+nums[i]);
            //遇到边界，更新边界，步数加一，直到最大位置maxpos为数组长度
            if(end == i){
                end = maxpos;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 贪心算法：正向寻找每一次能到达的最远位置
     * 时间复杂度：O(N*N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private int jump1(int[] nums){
        int len = nums.length - 1;
        int steps = 0;
        int pos = len;
        while (pos != 0){       //位置为起始位置时结束循环
            for (int i = 0; i < len; i++) {
                if(i+nums[i] >= pos){ //找到能达到最后位置的最小下标，steps加一，依次寻找直到位置为起始位置
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
