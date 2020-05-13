package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 */
public class Solution33 {
    /**
     * 使用队列先进先出的特点，将根节点放入队列再取出，判断是否有左右子节点，有就加到队中，依次循环知道队列为空
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (lists == null){
            return lists;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = nodes.remove(0);
                list.add(t.val);
                if(t.left != null){
                    nodes.add(t.left);
                }
                if(t.right != null){
                    nodes.add(t.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution33 ss = new Solution33();
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        root.left = t1;
        root.right = t2;
        t2.right = t3;
        for(List list:ss.levelOrder(root)){
            System.out.println(list);
        }
    }
}
