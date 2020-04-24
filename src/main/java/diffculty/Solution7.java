package diffculty;

/**
 * 求逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 * 使用归并排序
 * 时间：O(log2 n)
 * 空间：O（n）
 */
public class Solution7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        int[] nums = {7,5,6,4};
        System.out.println(s.reversePairs(nums));
    }
    private int reversePairs(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[nums.length];
        return mergesort(copy,0,nums.length - 1,temp);
    }

    /***
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int mergesort(int[] nums,int left,int right,int[] temp) {
        if(left == right){
            return 0;
        }
        int mid = left + (right - left)/2;
        int leftPairs = mergesort(nums,left,mid,temp);
        int rightPairs = mergesort(nums,mid+1,right,temp);
        if(nums[mid] <= nums[mid+1]){   //左边数组的最大值<=右边数组的最大值则直接返回左边逆序对加上右边的逆序对
            return leftPairs + rightPairs;
        }
        int curPairs = mergeAndCont(nums,left,mid,right,temp);
        return leftPairs+rightPairs+curPairs;
    }

    /**
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCont(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid+1;
        int count = 0;
        for (int k = left; k <= right ; k++) {
            if(i == mid + 1){       //左边已归并完
                nums[k] = temp[j];
            }
            else if(j == right + 1){//右边已归并完
                nums[k] = temp[i];
            }
            else if(temp[i] <= temp[j]){//左边小于右边，把左边放入
                nums[k] = temp[i];
                i++;
            }
            else {
                nums[k] = temp[j];//右边小于左边，把右边放入
                j++;
                count += (mid-i+1); //逆序对数即为左边数组还剩下的数的个数
            }
        }
        return count;
    }

}
