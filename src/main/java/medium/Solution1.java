package medium;

import java.util.Arrays;
/*
    使数组唯一的最小增量
    给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
    返回使 A 中的每个值都是唯一的最少操作次数
*/
public class Solution1 {
       //方法一：排序O(NlogN)
       /* public static int minIncrementForUnique(int[] A) {
            int count = 0;
            Arrays.sort(A);
            System.out.println(Arrays.toString(A));
            for (int i = 1; i < A.length; i++) {//遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
                if(A[i]<=A[i-1]){
                    int pre = A[i];
                    A[i] = A[i-1]+1;
                    count += A[i] - pre;
                }
            }
            return count;
        }*/
       //方法二： 线性探测法+路径压缩O(N)
        int[] pos = new int[1000];
        private  int minIncrementForUnique(int[] A) {
            Arrays.fill(pos,-1);
            int move = 0;
            // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数
            for(int a:A){
                int b = findPos(a);
                move += b - a;
            }
            return move;

        }
        //线性探测寻址（含路径压缩）
        private int findPos(int a){
            int b = pos[a];
            // 如果a对应的位置pos[a]是空位，直接放入即可。
            if(b == -1){
                pos[a] = a;
                return a;
            }
            // 否则向后寻址
            // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）
            b = findPos(b+1);
            pos[a] = b; // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里
            return b;

        }
        public static void main(String[] args) {
            Solution1 s = new Solution1();
            int[] n = {3,2,1,2,1,7};
            System.out.println(Arrays.toString(n));
            //System.out.println(minIncrementForUnique(n));
            System.out.println(s.minIncrementForUnique(n));

    }
}
