package medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 *和为K的子数组
 * 解法一：暴力枚举
 * 解法二：前缀和+hashmap
 */
public class Solution34 {
    /**
     * 枚举解法
     * 时间复杂度：O(N*N)
     * 空间复杂度：O(1)
     * @param nums
     * @param k
     * @return
     */
    private int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0 ; j--) {
                sum+=nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;

    }

    /**
     * 前缀和+hashmap
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @param k
     * @return
     */
    private int subarraySum1(int[] nums, int k) {
        int pre = 0,count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            //保证map的值为1
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;

    }
    public static void main(String[] args) {
        Solution34 s = new Solution34();
        int k = 2;
        int[] nums = {1,1,1};
        System.out.println(s.subarraySum1(nums,k));
    }
}
