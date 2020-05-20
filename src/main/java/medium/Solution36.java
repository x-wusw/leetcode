package medium;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 */
public class Solution36 {
    /**
     * 时间复杂度:O(n) n为字符串长度
     * 空间复杂度：O(s) s为状态数组的值，此题为s=2^5=32
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s){
        int len = s.length();
        //状态数组00000  5位数代表5个元音字母状态 故数组大小为2^5
        int[] n = new int[1<<5];//00000-11111的32个数
        //填充数组
        Arrays.fill(n,-1);
        int statu = 0,res = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //元音字母出现，做异或，出现偶数次或0次都为0
            if(c=='a'){
                statu ^= 1<<0;//00001
            }else if(c=='e'){
                statu ^= 1<<1;//00010
            }else if(c=='i'){
                statu ^= 1<<2;//00100
            }else if(c=='o'){
                statu ^= 1<<3;//01000
            }else if(c=='u'){
                statu ^= 1<<4;//10000
            }
            //字串中出现了偶数次的元音
            if(n[statu] >= 0){
                res = Math.max(res,i+1-n[statu]);//这次出现的位置减去上次出现的位置加一即为最大值
            }
            //字符串内元音字母出现次数不是偶数次，记录位置即可
            else {
                n[statu] = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution36 s = new Solution36();
        String s1 = "iaeae";
        System.out.println(s.findTheLongestSubstring(s1));
    }
}
