package simple;
/*
    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
    假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
    注意：每次拼写时，chars 中的每个字母都只能用一次。
    返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class Solution0 {
    public static int countCharacters(String[] words, String chars) {
        int len = 0;
        //获取chars的字母个数
        int[] charcount = count(chars);
        for (String word : words){
            int[] wordcount = count(word);
            if(isTrue(charcount,wordcount)){
                len+=word.length();
            }
        }
        return len;
    }
    //统计字符串中字母出现次数
    private static int[] count(String str){
        int[] count  = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[c-'a']++;
        }
        return count;
    }
    //判断word单词中的字母数是否小于等于chars中字母出现次数，真为能打出单词
    private static boolean isTrue(int[] charcount, int[] wordcount){
        for (int i = 0; i < 26; i++) {
            if(charcount[i]<wordcount[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words ={"hello","word","china"};
        String chars = "hellowordhhh";
        int n = countCharacters(words,chars);
        System.out.println("可拼写的单词总长度："+n);
    }
}
