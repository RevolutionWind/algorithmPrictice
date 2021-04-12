package recursion;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * @author sunxy
 * @date 2020/11/3
 */
@SuppressWarnings("unused")
public class MinDepth {

    /*
        深度遍历优先的搜索，记录每个结点左右子树的长度，并比较
     */
    public int minDepth(TreeNode root) {
        // 终结条件
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        // 后序遍历, 比较左右子树的长度
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

}
