package simple;
/*
    矩形重叠
    矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
    如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
    给出两个矩形，判断它们是否重叠并返回结果。
    解题思路：
    如果某个矩形的最左边大于等于另外一个的最右边或者
    某个矩形的最低边高于等于另外一个的最高的边，就输出false；否则就是true
 */
public class Solution1 {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        if(rec1[0]>=rec2[2] || rec2[0]>=rec1[2] || rec1[1]>=rec2[3] || rec2[1]>=rec1[3])
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] rec1 = {5,15,8,18};
        int[] rec2 = {0,3,7,9};
        System.out.println("rec1=["+rec1[0]+","+rec1[1]+","+rec1[2]+","+rec1[3]+"],"+"rec2=["+rec2[0]+","+rec2[1]+","+rec2[2]+","+rec2[3]+"]");
        System.out.println(isRectangleOverlap(rec1,rec2));
    }
}
