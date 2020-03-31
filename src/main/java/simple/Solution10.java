package simple;

import java.util.ArrayList;
import java.util.Scanner;

/*
    约瑟夫环
    递推公式：
    f(N,M)=(f(N−1,M)+M)%Nf(N,M)=(f(N-1,M)+M)\%N
    f(N,M)=(f(N−1,M)+M)%N

    f(N,M)f(N,M)f(N,M)表示，N个人报数，每报到M时杀掉那个人，最终胜利者的编号
    f(N−1,M)f(N-1,M)f(N−1,M)表示，N-1个人报数，每报到M时杀掉那个人，最终胜利者的编号

    圆圈中最后剩下的数字
    0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
    例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
    因此最后剩下的数字是3。


 */
public class Solution10 {
    //模拟法
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int res = 0;
        while (n>1){
            res = (res+m-1)%n;
            list.remove(res);
            n--;
        }
        return list.get(0);

    }
    //数学公式法
    public int lastRemaining1(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n ; i++) {
            res = (res+m)%i;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution10 s = new Solution10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(s.lastRemaining(n,m));
        System.out.println(s.lastRemaining1(n,m));

    }
}
