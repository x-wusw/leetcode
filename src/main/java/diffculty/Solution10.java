package diffculty;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 */
public class Solution10 {
    /**
     * 滑动窗口解决字串问题
     * 时间复杂度：O(n+s)n,s为两个字符串的长度
     * 空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    private String minWindow(String s,String t){
        int slen = s.length();
        int tlen = t.length();
        //储存t中字符出现的次数
        int[] need = new int[128];
        //储存s中字符出现次数
        int[] window  = new int[128];
        //记录瞒住条件的最小字串长度
        int minlen = slen + 1;
        //记录t中的字符在s中出现的次数
        int count = 0;
        int r = 0,l = 0;
        String res = "";
        for (int i = 0; i < tlen; i++) {
            char ch = t.charAt(i);
            need[ch]++;
        }
        //滑动窗口，找到满足条件的字串
        while (r < slen){
           char ch = s.charAt(r);
           window[ch]++;
           if(need[ch]>0&&need[ch]>=window[ch]){
                count++;
           }
           //移动左指针直到不瞒住条件
           while(count==tlen){
               ch = s.charAt(l);
               if(need[ch]>0&&need[ch]==window[ch]){
                   count--;
               }
               if(r-l+1<minlen){
                   minlen = r-l+1;
                   res = s.substring(l,r+1);
               }
               window[ch]--;
               l++;
           }
           r++;
       }
        return minlen==slen+1?"":res;
    }

    public static void main(String[] args) {
        Solution10 s = new Solution10();
        String ss = "abcdoefgdef";
        String tt = "def";
        System.out.println(s.minWindow(ss,tt));
    }
}
