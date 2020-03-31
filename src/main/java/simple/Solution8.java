package simple;

import java.util.HashMap;
import java.util.Map;

/*
    卡牌分组
    给定一副牌，每张牌上都写着一个整数。
    此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
    每组都有 X 张牌。
    组内所有的牌上都写着相同的整数。
    仅当你可选的 X >= 2 时返回 true。

 */
public class Solution8 {
    private boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int num : deck){
            count[num]++;
        }
        int x = 0;
        for(int cny : count){
            if(cny > 0){
                x = gcd(x,cny);
                if(x<=1){
                    return false;
                }
            }
        }
        return x>=2;
    }
    private int gcd(int x,int y){
        return y == 0 ? x: gcd(y,x%y);
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int[] s = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4};
        System.out.println(solution8.hasGroupsSizeX(s));

    }
}
