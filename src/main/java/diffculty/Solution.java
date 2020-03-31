package diffculty;
/*
    01背包
    w[i]为第i个物品的重量，v[i]为第i个物品的价值,V为背包容量，N为物品个数
 */
public class Solution {
    public static void main(String[] args) {
        int[] w = new int[]{0,2,2,2,5,5,7};
        int[] v = new int[]{0,4,4,3,9,10,8};
        int V = 17;
        int N = 6;
        int[][] res = maxValue(N,V,w,v);
        System.out.println(res[N][V]);
        int[] res1 = optimizeMaxValue(N,V,w,v);
        System.out.println(res1[V]);
    }
    //一般01背包
    public static int[][] maxValue(int N,int W,int[] w,int[] v){
        if(N < 0 || W < 0){
            return new int[0][0];
        }
        int[][] res = new int[N+1][W+1];
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[i].length; j++) {
                if(j - w[i] >= 0){
                    res[i][j] =  Math.max(res[i-1][j],res[i-1][j-w[i]]+v[i]);
                }else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res;
    }
    //优化为一维数组
    public static int[] optimizeMaxValue(int N,int W,int[] w,int[] v){
        int[] res = new int[W+1];
        for (int i = 1; i <= N ; i++) {
            for (int j = W; j >= w[i]; j--) {
                res[j] = Math.max(res[j],res[j-w[i]]+v[i]);
            }
        }
        return res;
    }
}
