package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 快乐数
 * 快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是
 * 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False
 */
public class Solution26 {
    private boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        while (n != 1){
            int temp = 0;
            while (n > 0){
                temp += Math.pow(n%10,2);
                n = n /10;
                if(map.containsKey(temp)){
                    return false;
                }else{
                    map.put(temp,1);
                }
            }
            n = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution26 s = new Solution26();
        System.out.println("1-100的快乐数有：");
        for (int i = 1; i < 100; i++) {
            if(s.isHappy(i)){
                System.out.print(i+" ");}
        }
    }
}
