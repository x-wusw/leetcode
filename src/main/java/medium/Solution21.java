package medium;

import java.util.*;

/**
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Solution21 {
    /**
     * bfs遍历，遍历每层的节点，每层最后一个即结果加入到结结果集
     * 时间空间复杂度都为O（n）,n为节点数
      private List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root == null){
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();//当前层数的节点数
                for (int i = 0; i < size; i++) {//遍历当前层数
                    TreeNode node = queue.poll();
                    if(root.left != null){//将左右子节点加入队列
                        queue.offer(root.left);
                    }
                    if(root.right != null){
                        queue.offer(root.right);
                    }
                    if(i == size-1){      //如果节点是当前层数最后遍历的节点加入结果列表
                        list.add(node.val);
                    }
                }
            }
            return list;
    }*/
    /**
     *  dfs遍历，遍历每层的节点，每层最后一个即结果加入到结结果集
     * 时间空间复杂度都为O（n）,n为节点数,最好情况为O（log2 n）
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点,
                                      // 因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


    public static void main(String[] args) {
        Solution21 s = new Solution21();
        TreeNode node = new TreeNode(1);
        System.out.println(s.rightSideView(node));

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

