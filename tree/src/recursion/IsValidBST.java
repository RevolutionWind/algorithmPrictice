package recursion;

/**
 * 98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author sunxy
 * @date 2020/11/3
 */
@SuppressWarnings("unused")
public class IsValidBST {

    private double last = -Double.MAX_VALUE;

    /*
        中序遍历验证是否是一个递增的数组
     */
    public boolean isValidBST(TreeNode root) {
        // 递归终止条件
        if (root == null) return true;
        if (isValidBST(root.left) && last < root.val) {
            last = root.val;
            return isValidBST(root.right);
        }
        return false;
    }

}
