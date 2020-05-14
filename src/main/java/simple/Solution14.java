package simple;


/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *
 */
public class Solution14 {
    /**
     * 异或运算  任何数与0异或结果为本身  任何数与自己异或结果为0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
       int sum = 0;
       for(int i : nums){
           sum ^= i;
       }
       return sum;
    }

    public static void main(String[] args) {
        Solution14 s = new Solution14();
        int[] nums = {1,1,2,2,3};
        System.out.println(s.singleNumber(nums));

    }
}
