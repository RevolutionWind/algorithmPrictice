package stack;

import recursion.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunxy
 * @date 2021/4/29 14:15
 */
@SuppressWarnings("unused")
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.right == null || node.right == pre) {
                res.add(node.val);
                pre = node;
                root = null;
            } else {
                stack.push(node);
                root = node.right;
            }
        }
        return res;
    }

}
