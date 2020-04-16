package medium;

import java.util.Arrays;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 时间复杂度：O(n\log n)O(nlogn)，其中 nn 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的O(nlogn)。
 * 空间复杂度：O(\log n)O(logn)，其中 nn 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(nlogn)即为排序所需要的空间复杂度。
 */
public class Solution16 {
    public static void main(String[] args) {
        Solution16  s = new Solution16();
        int[][] res = s.merge(new int[][]{{1,2},{2,4},{6,8}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }
    private int[][] merge(int[][] intervals){
        //按区间的起始位置排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        //遍历区间
        for (int[] interval : intervals){
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }
            // 反之将当前区间合并至结果数组的最后区间
            else {
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }

        }
        return Arrays.copyOf(res,idx+1);


    }
}
