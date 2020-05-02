package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 解法：滑动窗口
 * 时间复杂度：O(N)，其中 N是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
 * 空间复杂度：O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符
 *
 */
public class Solution27 {
    private int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if(i != 0){
                // 左指针向右移动一格，移除一个字符（遇到重复字符就重新标记）
                System.out.println("remove:"+s.charAt(i-1));
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))){
                // 不断地移动右指针
                System.out.print(s.charAt(rk+1)+" ");
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            System.out.println("rk:"+rk);
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans,rk - i +1);
            System.out.println("ans:"+ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution27 s = new Solution27();
        String s1 = "abbcd";
        System.out.println(s.lengthOfLongestSubstring(s1));
    }
}
