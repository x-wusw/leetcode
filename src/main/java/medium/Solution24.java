package medium;

/**
 *  搜索旋转排序数组
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别 --- 二分查找。
 */
public class Solution24 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    private int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid =  left + (right - left);
            if(target == nums[mid]){
                return mid;
            }
            //判断mid是在左边还是右边
            //在左边
            if(nums[mid] >= nums[left]) {
                //target在左边，就在左边找，否则在右边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //在右边
            else {
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        Solution24 s = new Solution24();
        int[] nums = {9,8,7,6,5,0,1,2,3};
        System.out.println(s.search(nums,4));
    }
}
