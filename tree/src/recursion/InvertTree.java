package recursion;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * leetcode226.翻转二叉树
 * 输入：
 * 4
 * / \
 * 2  7
 * /\  /\
 * 1 3 6 9
 * <p>
 * 输出：
 * 4
 * / \
 * 7   2
 * /\   /\
 * 9 6 3  1
 *
 * @author walker
 * @date 2020/8/13
 */
@SuppressWarnings("unused")
public class InvertTree {

    /*
     1. 递归: 前序遍历
     */
    TreeNode invertTree1(TreeNode root) {
        // 递归终结
        if (Objects.isNull(root)) return null;
        // 先下探到下一层，获取到翻转后的左子树
        TreeNode leftNode = invertTree1(root.left);
        // 使当前树的左节点指向翻转后的右子树
        root.left = invertTree1(root.right);
        // 使当前树的右节点指向翻转后的左子树
        root.right = leftNode;
        return root;
    }

    /*
    2. 迭代：
         (1) 交换所有节点中的左孩子和右孩子。
         (2) 创建一个队列，用来存储还没有被交换过孩子结点的结点
         (3) 刚开始的时候，只有根节点，交换其左孩子和右孩子，并将其左右孩子存入队列中
         (4) 直至队列为空
     */
    TreeNode invertTree2(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

}

