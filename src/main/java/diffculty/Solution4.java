package diffculty;

import java.util.HashMap;
import java.util.Map;
/*
        鸡蛋掉落----------------动态规划 + 二分搜索

        如果鸡蛋不碎，那么状态变成 (K, N-X)(K,N−X)，即我们鸡蛋的数目不变，但答案只可能在上方的 N-X,N−X 层楼了。也就是说,
        我们把原问题缩小成了一个规模为 (K, N-X)(K,N−X) 的子问题.
        如果鸡蛋碎了，那么状态变成 (K-1, X-1)(K−1,X−1)，即我们少了一个鸡蛋，但我们知道答案只可能在第 X 楼下方的 X-1X−1 层楼中了。
        也就是说，我们把原问题缩小成了一个规模为 (K-1, X-1)(K−1,X−1) 的子问题。
        这样一来，我们定义 dp(K, N)dp(K,N) 为在状态 (K, N)(K,N) 下最少需要的步数。根据以上分析我们可以列出状态转移方程：
        dp(K, N) = 1+ min(max(dp(K−1,X−1),dp(K,N−X)))

        第一个鸡蛋扔在的楼层数 X。由于我们并不知道真正的 F 值，因此我们必须保证 鸡蛋碎了之后接下来需要的步数和鸡蛋没碎之后接下来
        需要的步数二者的最大值最小，这样就保证了在最坏情况下（也就是无论 FF 的值如何）dp(K, N)dp(K,N) 的值最小。如果能理解这
        一点，也就能理解上面的状态转移方程，即最小化max(dp(K−1,X−1),dp(K,N−X))。

        时间复杂度：O(k*nlog（n）)
 */
public class Solution4 {
    Map<Integer,Integer> map = new HashMap();
    private int superEgg(int k,int n){
        return dp(k,n);
    }
    private int dp(int k,int n){
        if(!map.containsKey(k+100*100)){
            int value = 0;
            if(n == 0){         //楼层数为0，无法测出
                value = 0;
            }else if (k == 1){  //鸡蛋数为1时，遍历楼层数
                value = n;
            }else {
                int low = 1,high = n;
                while (low + 1 < high){
                    int x = (low + high)/2;
                    int t1 = dp(k-1,x-1);//鸡蛋碎了，目标在x一下即1到x之间
                    int t2 = dp(k,n-x);     //鸡蛋没碎，目标在x以上即在n到n-x之间
                    if(t1 < t2){
                        low = x;
                    }else if (t1 > t2){
                        high = x;
                    }else {
                        low = high = x;
                    }
                }
                value = 1 + Math.min(Math.max(dp(k-1,low-1),dp(k,n-low)),
                        Math.max(dp(k-1,high-1),dp(k,n-high)));
            }
            map.put(k+100*n,value);
        }
        return map.get(n*100+k);
    }
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int k = 3;
        int n = 14;
        System.out.println(s.superEgg(k,n));
    }
}
