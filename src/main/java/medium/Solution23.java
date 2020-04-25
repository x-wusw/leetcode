package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排序
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * 回溯法
 * 时间复杂度：O(n*n!)
 * 空间复杂度：O(n)
 */
public class Solution23 {
    public static void main(String[] args) {
        Solution23 s = new Solution23();
        int[] nums = {1,2,3};
        System.out.println(s.permute(nums));
    }
    private List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        //结果列表集
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        //状态数组
        boolean[] used = new boolean[len];
        //结果列表
        List<Integer> path = new ArrayList<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                System.out.println("递归前   "+ path);
                dfs(nums,len,depth+1,path,used,res);
                System.out.println("递归后   "+ path);

                //回溯  状态重置
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
