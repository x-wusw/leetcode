package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
    最小的k个数
    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Solution3 {
    static ArrayList<Integer> KMin(int[] array, int k){
        if(array==null) return null;
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        if(k>array.length){
            return list;
        }
        int temp;
        for(int i = 0; i < k; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            list.add(array[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = {1,3,4,5,6,7,6,2,56,32,12,54,23,21};
        System.out.print(Arrays.toString(n) +"请输出取出个数k：");
        int k = sc.nextInt();
        ArrayList<Integer> list = KMin(n,k);
        System.out.println(list);


    }
}
