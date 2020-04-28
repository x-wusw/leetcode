package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Solution25 {
    /*private int[] singleNumbers(int[] nums) {
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] n = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            n[k++] = it.next();
        }

        return n;

    }*/
    private int[] singleNumbers(int[] nums){
        int sum = 0;
        //得到两个出现一次的数字异或结果  1^2^3^1^2^4 = 3^4
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        //得到sum的二进制的1的最低位
        int lowbit = (-sum) & sum;
        int[] a = new int[2];
        //分成两个组进行异或，每组异或后的结果就是不相同两个数的其中之一
        for (int val : nums) {
            if((val & lowbit) == 0) {
                a[0] ^= val;
            }
        }
        //根据异或自反性
        a[1] = sum^a[0];
        return a;
    }
    public static void main(String[] args) {
        Solution25 s = new Solution25();
        int[] n = {1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(s.singleNumbers(n)));
    }
}

