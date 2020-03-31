package medium;

import java.util.Arrays;

/*
    单词的压缩编码
    给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
    例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
    对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String[] words = {"time", "me", "bell"};
        System.out.println(s.minimumLengthEncoding(words));

    }
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Tire tire = new Tire();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += tire.insert(word);
        }
        return len;
    }


}
//建立tire前缀树（字典树）
class Tire{
    TireNode root;
    public Tire(){
        root = new TireNode();
    }
    public int insert(String word){
        TireNode cur = root;
        boolean isNew = false;
        // 倒着插入单词
        for (int i = word.length()-1; i >= 0 ; --i) {
            int c = word.charAt(i)-'a';
            if(cur.children[c] == null){
                isNew = true;
                cur.children[c] = new TireNode();
            }
            cur = cur.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew ? word.length() + 1 : 0 ;
    }
}
class TireNode{
    char val;
    TireNode[] children = new TireNode[26];
    public TireNode(){}
    public TireNode(char val){
        this.val = val;
    }
}
