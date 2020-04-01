package medium;
/*
    有效括号的嵌套深度
    有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
    嵌套深度 depth 定义：即有效括号字符串嵌套的层数。详情参见题末「嵌套深度」部分。
    给你一个「有效括号字符串」 seq，请你将其分成两个不相交的子序列 A 和 B，且 A 和 B 都满足有效括号字符串的定义
    （注意：A.length + B.length = seq.length）。
    由于可能存在多种划分方案，请你从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
    其中 depth(A) 表示 A 的嵌套深度，depth(B) 表示 B 的嵌套深度。
    请你返回一个长度为 seq.length 的答案数组 answer，编码规则如下：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。
    否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 */

public class Solution5 {
    public int[] maxDepthAfterSplit(String seq){
        int idx = 0;
        int[] ans = new int[seq.length()];
        char[] chars = seq.toCharArray();
        for (char c : chars){
            //c为‘（’，数组值为0，否则为1
            ans[idx] = c =='('? idx&1 : (idx+1)&1 ;
            idx+=1;
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String s1 = "((()))";
        int[] ints = s.maxDepthAfterSplit(s1);
        for(int i : ints){
            System.out.print(ints[i]+" ");
        }
    }
}
