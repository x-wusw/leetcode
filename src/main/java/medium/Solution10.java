package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  括号生成
 *  数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution10 {
    List<String> list =new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return list;

    }
    private void dfs(int l,int r,String str){
        if(l == 0 && r == 0){//左右括号都不剩余了，递归终止
            list.add(str);
            return ;
        }
        if(l > 0){
            dfs(l - 1,r,str+"(");//左边括号还有剩余，继续递归
        }
        if(r > l){
            dfs(l,r - 1,str+")");//如果右括号剩余多于左括号剩余的话，可以拼接右括
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution10 s = new Solution10();
        for(String list1 :s.generateParenthesis(n)){
                System.out.println(list1);
        }

    }
}
