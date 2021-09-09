package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的前、中、后序遍历
 *
 * @author walker
 * @date 2020-08-07
 */
@SuppressWarnings("unused")
public class TwoChildrenTree {
    List<Integer> list = new ArrayList<>();

    /*
    前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    /*
    中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    /*
    后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Dog {
    int val;
    Dog[] childs;

    Dog(int x) {
        val = x;
    }
}
