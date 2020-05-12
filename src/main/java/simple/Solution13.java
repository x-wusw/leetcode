package simple;

/**
 *  二叉树的最近公共祖先
 */
public class Solution13 {
    private TreeNode ans;

    public Solution13() {
        this.ans = null;
    }

    /**
     * 递归遍历整棵二叉树，定义 f_x
     * 表示 xx 节点的子树中是否包含 p节点或 q节点，如果包含为 true，否则为 false。那么符合条件的最近公共祖先 xx 一定满足如下条件：
     *      (left&&right)||(root.val==p.val||root.val == q.val)&&(left||right)
     *
     *      left&&right说明左子树和右子树均包含 pp 节点或 qq 节点，如果左子树包含的是 pp 节点，那么右子树只能包含 qq 节点，反之亦然，
     *      因为 pp 节点和 qq 节点都是不同且唯一的节点，因此如果满足这个判断条件即可说明 xx 就是我们要找的最近公共祖先。
     *      再来看第二条判断条件，这个判断条件即是考虑了 xx 恰好是 pp 节点或 qq 节点且它的左子树或右子树有一个包含了另一个节点的
     *      情况，因此如果满足这个判断条件亦可说明 xx 就是我们要找的最近公共祖先

     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){return false;}
        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);
        if((left&&right)||(root.val==p.val||root.val == q.val)&&(left||right)){
           ans = root;
        }
        return left&&right || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return this.ans;

    }
}

class TreeNode13{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode13(int x){
        val = x;
    }
}