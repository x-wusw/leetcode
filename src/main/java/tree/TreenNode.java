package tree;
/**
 * 静态创建数
 */
public class TreenNode {
    private int val;
    private TreenNode leftTreeNode;
    private TreenNode rightTreeNode;

    public TreenNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreenNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreenNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreenNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public TreenNode(int x){
        val = x;
    }
    //前序遍历 根左右
    public static void preTraverseBTree(TreenNode root){
        if(root != null){
            System.out.println(root.val);
            preTraverseBTree(root.getLeftTreeNode());
            preTraverseBTree(root.getRightTreeNode());
        }

    }
    //中序遍历 左根右
    public static void inTraverseBTree(TreenNode root){
        if(root != null){
            inTraverseBTree(root.getLeftTreeNode());
            System.out.println(root.val);
            inTraverseBTree(root.getRightTreeNode());
        }
    }
    //后序遍历 左右根
    public static void hearTraverseBTree(TreenNode root){
        if(root != null){
            hearTraverseBTree(root.getLeftTreeNode());
            hearTraverseBTree(root.getRightTreeNode());
            System.out.println(root.val);
        }
    }
    public static void main(String[] args) {
        TreenNode node = new TreenNode(1);
        TreenNode node1 = new TreenNode(5);
        TreenNode node2 = new TreenNode(54);
        TreenNode node3 = new TreenNode(34);
        TreenNode node4 = new TreenNode(2);
        node.setLeftTreeNode(node1);
        node.setRightTreeNode(node2);
        node1.setLeftTreeNode(node3);
        node2.setRightTreeNode(node4);
        System.out.println("前序遍历");
        preTraverseBTree(node);
        System.out.println("中序遍历");
        inTraverseBTree(node);
        System.out.println("后序遍历");
        hearTraverseBTree(node);

    }




}
