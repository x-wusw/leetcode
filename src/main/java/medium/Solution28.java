package medium;

/**
 * 验证二叉搜索树
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
public class Solution28 {
    private boolean isValidBST(TreeNode1 root) {
        return is(root,null,null);

    }

    /**
     * 判断左节点是否比根节点小，右节点是否比根节点大
     * @param root
     * @param low
     * @param up
     * @return
     */
    private boolean is(TreeNode1 root,Integer low,Integer up){
        if(root == null){return true;}
        int val = root.val;
        if(low != null && val <= low){
            return false;
        }
        if(up != null && val >= up){
            return false;
        }
        if(!is(root.left,low,val)){
            return false;
        }
        if(!is(root.right,val,up)){
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Solution28 s = new Solution28();
        TreeNode1 root = new TreeNode1(2);
        TreeNode1 t1 = new TreeNode1(1);
        TreeNode1 t2 = new TreeNode1(3);
        TreeNode1 t3 = new TreeNode1(4);
        root.left = t1;
        root.right = t2;
        t2.right = t3;
        System.out.println(s.isValidBST(root));

    }
}
class TreeNode1{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x){
        val = x;
    }
}