package simple;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class Solution15 {
    /**
     * 双指针
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    private boolean validPalindrome(String s) {
        int len = s.length();
        int l = 0,r = len-1;
        while (l<r){
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);
            if(c1 == c2){
                l++;
                r--;
            }else{
                boolean f1 = true,f2 = true;
                for (int i = l+1,j = r; i < j; i++,j--) {
                    if(s.charAt(i) != s.charAt(j)){
                        f1 = false;
                        break;
                    }
                }
                for (int i = l,j = r - 1; i < j; i++,j--) {
                    if(s.charAt(i) != s.charAt(j)){
                        f2 = false;
                        break;
                    }
                }
                return f1 || f2;
            }
        }
    return true;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        String s1 = "aba";
        System.out.println(s.validPalindrome(s1));
    }
}
