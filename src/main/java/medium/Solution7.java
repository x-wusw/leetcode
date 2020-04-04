package medium;

import java.util.Scanner;

/*
       实现一个 atoi 函数，使其能将字符串转换成整数。

    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
        如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
        假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
        该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
        注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，
        即无法进行有效转换。
        在任何情况下，若函数不能进行有效的转换时，请返回 0 。
    提示：
    本题中的空白字符只包括空格字符 ' ' 。
 */
public class Solution7 {
    private int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        int n = chars.length;
        while (index < n && chars[index] == ' '){
            index++;
        }
        if(index == n){
            return 0;
        }
        boolean b = false;
        if(chars[index] == '-'){
            index++;
            b = true;
        }else if (chars[index] == '+'){
            index++;
        }else if(!Character.isDigit(chars[index])){
            return 0;
        }
        int ans = 0;
        while (index < n && Character.isDigit(chars[index])){
            int digit = chars[index] - '0';
            if((ans*10)+digit > Integer.MAX_VALUE){
                return b ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return b ? -ans : ans;

    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String s = new Scanner(System.in).nextLine();
        int a = solution7.myAtoi(s);
        System.out.println(a);

    }
}
