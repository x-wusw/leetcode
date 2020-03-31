package medium;

import java.util.Scanner;

/*
    水壶问题
    有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
    如果可以，最后请用以上水壶中的一或两个来盛放取得的z水。
    你允许：
    装满任意一个水壶
    清空任意一个水壶
    从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class Solution0 {
    //求最大公约数
    public static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    //x,y的最大公约数能否被z整除，能则瞒住条件
    public static boolean canMeasureWater(int x, int y, int z) {
        int a = gcd(x,y);
        if(x==z||y==z||x+y==z){
           return true;
        }
        if(z%a==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(canMeasureWater(a,b,c));
        //System.out.println(gcd(a,b));
    }
}
