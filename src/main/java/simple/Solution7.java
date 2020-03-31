package simple;

import java.util.Arrays;

/*  车的可用捕获量
    在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
    它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
    车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
    直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
    返回车能够在一次移动中捕获到的卒的数量。
 */
public class Solution7 {
    public int numRookCaptures(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                //找到R的位置
                if(board[i][j]=='R'){
                    //以R 为原点建立坐标系
                    //依次向上找,向下找,向右找,向左找
                    return cap(board,i,j,0,1)+cap(board,i,j,0,-1)+cap(board,i,j,1,0)+cap(board,i,j,-1,0);
                }
            }
        }
        return 0;
    }
    public int cap(char[][] a,int x,int y,int dx,int dy){
        /*参数说明
         *a为原数组矩阵
         *x,y为R的坐标
         *dx,dy为增长步长
         */
        while(x>=0 && x<a.length && y>=0 && y<a[x].length && a[x][y]!='B'){
            if(a[x][y]=='p'){
                return 1;
            }
            x+=dx;
            y+=dy;
        }
        return 0;
    }
    public static void main(String[] args) {
        char[][] chars = {
                {'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        Solution7 s = new Solution7();
        System.out.println(s.numRookCaptures(chars));
    }
}
