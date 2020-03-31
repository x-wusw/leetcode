package simple;
/*
    输入一个字符串，输出最大不包含重复字母的子串大小
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution9 {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if(list.contains(chars[i])){
                if(max < list.size()){
                    max = list.size();
                }
                list.clear();
            }
            else {
                list.add(chars[i]);
            }
        }
        if(max < list.size()){
            max = list.size();
        }
        System.out.println(max);
    }
}
