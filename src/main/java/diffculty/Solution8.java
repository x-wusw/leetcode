package diffculty;

/**
 * 1095. 山脉数组中查找目标值
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 * 思路二分查找
 * 先用二分找到山脉数组的峰顶元素
 * 再用二分查找分别查找峰顶元素的左右两边数组元素
 * 空间复杂度： O(1)
 * 时间复杂度： O（log2 n） n为数组元素个数
 *
 */
public class Solution8{
    public interface MountainArray {
        public int get(int index);
        public int length();
    }

    private int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = mountainArr.get(0);
        int right = mountainArr.get(len -1);
        int mid = left + ((right - left)>>1);
        //找到峰值
        while (left<right){
            if(mountainArr.get(mid) < target){
                left = mid + 1;
            }else {
                right = mid;
            }
            mid = left + ((right - left)>>1);
        }
        //左边寻找
        left = 0;
        //记录峰值
        int temp = right;
        //目标值不在数组内
        if(target > mountainArr.get(right) || target < mountainArr.get(0)){
            return -1;
        }
        int midle = left + (right - left)>>1;
        while (left < right){
            if(mountainArr.get(midle) == target){
                return midle;
            }
            if(mountainArr.get(midle) > target){
                right = midle;
            }else {
                left = midle + 1;
            }
            midle = (left + right)>>1;
        }
        //右边寻找
        left = temp;
        right = mountainArr.length();
        midle = left + ((right - left)>>1);
        while (left < right){
            if(mountainArr.get(midle) == target){
                return midle;
            }
            if(mountainArr.get(mid) > target){
                right = midle;
            }else {
                left = midle + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution8 s = new Solution8();
        int[] nums = {1,2,3,4,3,1};
        int target = 0;
        int a = s.findInMountainArray(target, new MountainArray() {
            @Override
            public int get(int index) {
                return nums[index];
            }

            @Override
            public int length() {
                return nums.length;
            }
        });
        System.out.println(a);
    }
}