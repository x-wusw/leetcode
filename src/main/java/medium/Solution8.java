package medium;

public class Solution8 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //先左右翻滚
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = temp;
            }
        }
        //再以左下到右上的对角线翻滚
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Solution8 s = new Solution8();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        s.rotate(a);
        System.out.println("=========================================");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
