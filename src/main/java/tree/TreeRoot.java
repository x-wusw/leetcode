package tree;

/**
 * 动态建树
 */
public class TreeRoot {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 动态建二叉树
     * root 根节点
     * value 节点值
     */
    public static void createTree(TreeRoot root,int value){
        //如果树根为空(第⼀次访问)，将第⼀个值作为根节点
        if(root.getRoot() == null){
            TreeNode treeNode = new TreeNode(value);
            root.setRoot(treeNode);
        }else {
            //当前树根
            TreeNode tempRoot = root.getRoot();
            while (tempRoot != null){
                //当前值⼤于根值，往右边⾛
                if(value > tempRoot.getVal()){
                    //右边没有树根，那就直接插⼊
                    if(tempRoot.getRightTreeNode() == null){
                        tempRoot.setRightTreeNode(new TreeNode(value));
                        return;
                    }else {
                        //如果右边有树根，到右边的树根去
                        tempRoot = tempRoot.getRightTreeNode();
                    }
                }else {
                    //左没有树根，那就直接插⼊
                    if(tempRoot.getLeftTreeNode() == null){
                        tempRoot.setLeftTreeNode(new TreeNode(value));
                        return;
                        //如果左有树根，到左边的树根去
                    }else {
                        tempRoot = tempRoot.getLeftTreeNode();
                    }
                }
            }
        }
    }
    //前序遍历 根左右
    public static void preTraverseBTree(TreeNode root){
        if(root != null){
            System.out.println(root.getVal());
            preTraverseBTree(root.getLeftTreeNode());
            preTraverseBTree(root.getRightTreeNode());
        }

    }
    //中序遍历 左根右
    public static void inTraverseBTree(TreeNode root){
        if(root != null){
            inTraverseBTree(root.getLeftTreeNode());
            System.out.println(root.getVal());
            inTraverseBTree(root.getRightTreeNode());
        }
    }
    //后序遍历 左右根
    public static void hearTraverseBTree(TreeNode root){
        if(root != null){
            hearTraverseBTree(root.getLeftTreeNode());
            hearTraverseBTree(root.getRightTreeNode());
            System.out.println(root.getVal());
        }
    }
    public static void main(String[] args) {
        int[] a = {1,23,3,4,6,2,3};
        TreeRoot t = new TreeRoot();
        for (int value : a){
            createTree(t,value);
        }
        System.out.println("前序遍历：");
        preTraverseBTree(t.getRoot());
        System.out.println("中序遍历：");
        inTraverseBTree(t.getRoot());

    }
}
class TreeNode {
    private int val;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public TreeNode(int x) {
        val = x;
    }
}