package medium;

import java.util.HashMap;

/**
 * 523. 连续的子数组和
 *给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，
 * 即总和为 n*k，其中 n 也是一个整数。
 *
 * 时间复杂度：o(m)    m为数组的长度
 * 空间复杂度：o(min(m,k))
 */
public class Solution31 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0){
                sum = sum % k;
            }
            if(map.containsKey(sum)){   //直到map有重复值出现，判断字数组的长度是否>1,真返回true
                if(i - map.get(sum) > 1){
                    return true;
                }else {                 //更新
                    map.put(sum,i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution31 s = new Solution31();
        int[] nums = {0,0};
        int k = 0;
        System.out.println(s.checkSubarraySum(nums,k));
    }
}
