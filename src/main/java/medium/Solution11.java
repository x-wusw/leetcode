package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *  翻转字符串里的单词
 *  给定一个字符串，逐个翻转字符串中的每个单词。
 *  无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Solution11 {
    public String reverseWords(String s) {
        /*String[] words = s.trim().split(" ");//去掉前置和末尾空格，以空格为分隔符切割字符串放入String数组
        Collections.reverse(Arrays.asList(words));//倒转String数组中单词的顺序
        return String.join(" ", words);//将String数组中单词以空格连接起来并转为字符串*/
        String s1 = s.trim();
        String[] ch = s1.split(" ");
        Collections.reverse(Arrays.asList(ch));
        String s2 = String.join(" ",ch);
        return s2;

    }

    public static void main(String[] args) {
        Solution11 s = new Solution11();
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        System.out.println(s.reverseWords(m));
    }
}
