package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
@SuppressWarnings("unused")
public class BuildTree {
    /**
     * 中序数组的Hash缓存
     */
    Map<Integer, Integer> cache;
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        cache = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        post = postOrder;
        return buildTree(0, inorder.length - 1, 0, postOrder.length - 1);
    }

    /*
        根据数组位置建立二叉树
            ri: 根节点在中序序列中对应的下标
            二叉树的左、右子树在中、后序边界的
                inStart: 中序遍历的起始位置, inEnd: 中序遍历的结束位置
                postStart: 后序遍历的起始位置, postEnd: 后续遍历的结束位置
     */
    private TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        // 递归终止条件
        if (inStart < inEnd || postStart < postEnd) {
            return null;
        }
        int root = post[postEnd];
        int index = cache.get(root);
        TreeNode node = new TreeNode(root);
        int leftLen = index - inStart;
        node.left = buildTree(inStart, index - 1, postStart, postStart + leftLen);
        node.right = buildTree(index + 1, inEnd, postStart + leftLen + 1, postEnd - 1);
        return node;
    }

}

