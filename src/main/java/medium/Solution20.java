package medium;

import java.util.Arrays;

/**优美子数组的数目：
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * 时间空间复杂度都为o（n） n为数组长度
 */
public class Solution20 {
    private int numberofSub(int[] nums,int k){
        if(nums.length == 0 ||nums == null){
            return 0;
        }
        int len = nums.length;
        int res = 0;
        int temp = 0;
        int[] odd = new int[len+2];//+2是为了处理数组全为奇数的情况，再加上左右边界所以有数组长度+2
        for (int i = 0; i < len; i++) {
            //将奇数放入数组odd。odd的值即为奇数在原数组的下标
            if(nums[i]/2==0){
                odd[++temp] = i;
            }
        }
        //左右边界判断
        odd[0] = -1;
        odd[++temp] = len;
        for (int j = 1; j + k <= temp ; ++j) {
            res+=(odd[j] - odd[j-1])*(odd[j+k]-odd[j+k-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution20 s = new Solution20();
        int[] ints = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(Arrays.toString(ints));
        System.out.println("优美子数组个数为"+s.numberofSub(ints,k));

    }
}
