package medium;

import java.util.*;

/**
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 */
public class Solution12 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < len;i++){
            list.add(index[i],nums[i]);
        }

        int[] target = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }
    public int[] createTargetArray1(int[] nums, int[] index) {
        // 判空处理
        if(nums == null || nums.length == 0){
            return nums;
        }
        // 初始化返回数组,并赋值为-1
        int[] target = new int[nums.length];
        Arrays.fill(target, -1);
        int i = 0, j = i;
        // 遍历数组,在target下标index[i]处插入nums[i] (是插入,别写成替换了)
        for(; i < target.length; i++){
            // 判断是否为-1(未使用的位置),如果该位置已被使用,则需依次后移一位
            if(target[index[i]] != -1){
                // 从后往前判断,依次将所插入元素后移一位,腾出位置给当前元素插入
                for(j = nums.length; j > index[i]; j--){
                    if(target[j - 1] != -1){
                        target[j] = target[j - 1];
                    }
                }
            }
            // 插入元素
            target[index[i]] = nums[i];
        }
        // 返回结果
        return target;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        int[] nums = {0,1,2,3,4,5};
        int[] index = {1,0,2,3,4,4};
        int[] target = s.createTargetArray1(nums,index);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i]+" ");
        }

    }
}
