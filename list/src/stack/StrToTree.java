package stack;


import java.util.Stack;

/**
 * 将字符串的内容转换为一棵二叉树
 * 从控制台中输入一串“A(B(C,D(,E)),F(G,H(M,N(,Q))))“，将其转化建立一棵二叉树。
 *
 * @author sunxy
 * @date 2021/8/26 10:25
 */
@SuppressWarnings("unused")
public class StrToTree {

    public static TreeNode strToTree(String str) {
        if (str == null || str.length() < 1) return null;
        TreeNode root = null, node = null;
        int k = 0;
        char cur = '\0';
        Stack<TreeNode> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    // 1 代表左子树
                    k = 1;
                    stack.add(node);
                    break;
                case ',':
                    // 2 代表右子树
                    k = 2;
                    break;
                case ')':
                    stack.pop();
                    break;
                default:
                    node = new TreeNode(c);
                    // 字母
                    if (root == null) {
                        root = node;
                        continue;
                    }
                    switch (k) {
                        case 1:
                            stack.peek().left = node;
                            break;
                        case 2:
                            stack.peek().right = node;
                            break;
                    }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = strToTree("A(B(C,D(,E)),F(G,H(M,N(,Q))))");
        System.out.println();
    }
}



class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}