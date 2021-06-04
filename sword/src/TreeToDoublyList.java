
/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @author sunxy
 * @date 2021/6/1 14:51
 */
@SuppressWarnings("unused")
public class TreeToDoublyList {

    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(TreeNode cur) {
        if (cur == null) return;
        // 递归左子树，即 dfs(cur.left)
        dfs(cur.left);
        if (pre != null) {
            // 当 pre 不为空时：修改双向节点引用，即 pre.right = cur
            pre.right = cur;
        } else {
            // 当 pre 为空时：代表正在访问链表头节点，记为head；
            head = cur;
        }
        cur.left = pre;
        // 保存 cur ： 更新 pre = cur ，即节点 cur 是后继节点的 pre ；
        pre = cur;
        dfs(cur.right);
    }

}
