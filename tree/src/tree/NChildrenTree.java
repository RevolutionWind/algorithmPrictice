package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * n叉树的前序遍历
 *
 * @author walker
 * @date 2020-08-07
 */
@SuppressWarnings("unused")
public class NChildrenTree {
    List<Integer> list = new ArrayList<>();

    public void preOrder(nTreeNode root) {
        if (root == null) return;
        list.add(root.val);
        root.children.forEach(this::preOrder);
    }
}

@SuppressWarnings("unused")
class nTreeNode {
    public int val;
    public List<nTreeNode> children;

    public nTreeNode() {
    }

    public nTreeNode(int _val) {
        val = _val;
    }

    public nTreeNode(int _val, List<nTreeNode> _children) {
        val = _val;
        children = _children;
    }
}