package simple;

/**
 *572. 另一个树的子树
 * 递归：判断t树与s树、是的左子树、是的右子树是否相同
 */
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        TreeNode s = new TreeNode(3);
        TreeNode s1 = new TreeNode(4);
        TreeNode s2 = new TreeNode(5);
        TreeNode s3 = new TreeNode(1);
        TreeNode s4 = new TreeNode(2);
        s.left = s1;
        s.right = s2;
        s1.left = s3;
        s1.right = s4;
        TreeNode t = new TreeNode(4);
        t.left = s3;
        t.right = s4;
        System.out.println(solution12.isSubtree(s,t));
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        //判断s和t，s的左子树与t，s的右子树与t是否相同
        return isSample(s,t) || isSample(s.left,t) || isSample(s.right,t);

    }

    /**
     * 判断数结构是否相同
     * @param s
     * @param t
     * @return
     */
    private boolean isSample(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSample(s.left,t.left) && isSample(s.right,t.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        val = x;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}