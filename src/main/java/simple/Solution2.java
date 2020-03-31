package simple;

import java.util.HashSet;
import java.util.Scanner;

/*
    最长回文串:回文串（palindromic string）是指这个字符串无论从左读还是从右读，所读的顺序是一样的；
    简而言之，回文串是左右对称的
    题目：求最长回文串
    给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class Solution2 {
    //判断字符串是否是回文串
    public static boolean ishuiwen(String str){
        int left = 0;
        int right = str.length()-1;
        char[] chars = str.toCharArray();
        while (left<right){
            if(!(chars[left++]==chars[right++])){
                return false;
            }
       }
        return true;
    }
    /*求最长字符串的长度
    利用hashset，遍历字符串数组，判断字符是否在hashset中，如果在则加2，并在hashset中移除改字符，反之则放入hashset中
    最后判断count是否大于字符串长度*/
    public static int maxLen(String s){
        int count = 0;
        char[] chars = s.toCharArray();
        HashSet set = new HashSet();
        for(int i = 0;i < chars.length; i++){
            char b = chars[i];
            if(set.contains(b)){
                count += 2;
                set.remove(b);
            }else{
                set.add(b);
            }
        }
        if(count < s.length()){
            count ++;
        }
        return count;
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0 || len == 1)
            return s;
        int[][] dp = new int[len][len]; //定义二位数组存储值，dp值为1表示true，为0表示false
        int start = 0;  //回文串的开始位置
        int max = 1;   //回文串的最大长度
        for(int i = 0; i < len; i++){  //初始化状态
            dp[i][i] = 1;
            if(i < len - 1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }
        for(int l = 3; l <= len; l++){  //l表示检索的子串长度，等于3表示先检索长度为3的子串
            for (int i = 0; i+l-1 < len; i++){
                int j = l+i-1;  //终止字符位置
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){  //状态转移
                    dp[i][j] = 1;  //是一，不是字母l
                    start = i;
                    max = l;
                }
            }
        }
        return s.substring(start,start + max);   //获取最长回文子串
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(maxLen(str));
        System.out.println(longestPalindrome(str));

    }
}
