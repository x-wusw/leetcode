package medium;

/**优美子数组的数目
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 */
public class Solution20 {
    private int numberofSub(int[] nums,int k){
        if(nums.length == 0 ||nums == null){
            return 0;
        }
        int len = nums.length;
        int res = 0;
        int temp = 0;
        int[] odd = new int[len+1];
        for (int i = 0; i < len; i++) {
            if(nums[i]/2==0){
                odd[++temp] = i;
            }
        }
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
        System.out.println(s.numberofSub(ints,k));

    }
}
