package recursion;

/**
 * 剑指offer68. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author sunxy
 * @date 2020/8/13
 */
@SuppressWarnings("unused")
public class LowestCommonAncestor {

    /*
    递归遍历：
    三种情况，（1）p,q在root的左、右子树，则root就是当前子树的最近公共祖先
            （2）p,q都在root的左子树
            （3）p,q都在root的右子树
           用后序遍历进行二叉树的遍历，当遇到结点p或者结点q时返回，如果root
     */
    public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null || root == p || root == q) return root;
        // 下探到下一层
        TreeNode leftTree = findCommonAncestor(root.left, p, q);
        TreeNode rightTree = findCommonAncestor(root.right, p, q);
        // 如果左右子树都包含p、q, 说明是最近的公共子节点
        if (leftTree != null && rightTree != null) return root;
        // 如果一颗子树包含p、q节点, 则返回该子树
        return leftTree == null ? rightTree : leftTree;
    }

}
