package medium;

/*
    排序数组
    给你一个整数数组 nums，请你将该数组升序排列。
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = new int[]{1,2,3,0,4,11,23,4,5,2,3,1};
        int[] ss = solution4.sortArray4(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(ss[i]+" ");
        }
    }
    //冒泡
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[j]<nums[j-1]){
                    int t = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = t;
                }
            }
        }
        return nums;
    }
    //选择
    public int[] sortArray1(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int t = i;
            for (int j = nums.length - 1; j>i; j--) {
                if(nums[j]<nums[t]){
                    t = j;
                }
            }
            int temp = nums[t];
            nums[t] = nums[i];
            nums[i] = temp;

        }
        return nums;
    }
    //插入
    public int[] sortArray2(int[] nums){
        int j;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            for (j = i; j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = temp;
        }
        return nums;
    }

    //快速
    public int[] sortArray3(int[] nums,int start,int end) {
        if(start > end){
            return new int[0];
        }
        int i,j;
        i = start;
        j = end;
        int key = nums[start];
        while (i<j){
            while (i<j&&nums[j]>key){j--;}
            while (i<j&&nums[i]<=key){i++;}
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        int t1 = nums[i];
        nums[i] = nums[start];
        nums[start] = t1;

        sortArray3(nums,start,i-1);
        sortArray3(nums,i+1,end);

        return nums;
    }
    //希尔（先分组，在插入）
    public int[] sortArray4(int[] nums){
        int i,j,increment;
        for (increment = nums.length/2;increment>0;increment/=2) {
            for (i = increment; i< nums.length ; i++) {
                int temp = nums[i];
                for(j = i;j>=increment;j-=increment){
                    if(temp<nums[j-increment]){
                        nums[j] = nums[j-increment];
                    }else {
                        break;
                    }
                }
                nums[j] = temp;
            }
        }
        return nums;
    }
}
