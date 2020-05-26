package medium;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Solution37 {
    /**
     * 快慢指针：因为有重复的数字，数组可以看出一个环链，第一步找到第一次相遇的地方即入口，第二步，再次相遇的地方即答案
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        //找到第一次相遇的地方
        do {
            fast = nums[fast];
            slow = nums[nums[slow]];
        }while (fast!=slow);
        slow = 0;
        //找到第二次相遇的地方
        while (slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String[] args) {
        Solution37 ss = new Solution37();
        int[] nums = {1,2,3,3,4,5};
        System.out.println(ss.findDuplicate(nums));
    }
}
