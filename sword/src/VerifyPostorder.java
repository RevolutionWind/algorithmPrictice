/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * @author sunxy
 * @date 2021/6/1 13:40
 */
@SuppressWarnings("unused")
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    // 递归实现
    private boolean verify(int[] postorder, int left, int right) {
        if (left >= right) return true; // 当前区域不合法的时候直接返回true就好

        int rootValue = postorder[right]; // 当前树的根节点的值

        int k = left;
        while (k < right && postorder[k] < rootValue) { // 从当前区域找到第一个大于根节点的，说明后续区域数值都在右子树中
            k++;
        }

        for (int i = k; i < right; i++) { // 进行判断后续的区域是否所有的值都是大于当前的根节点，如果出现小于的值就直接返回false
            if (postorder[i] < rootValue) return false;
        }

        // 当前树没问题就检查左右子树
        if (!verify(postorder, left, k - 1)) return false; // 检查左子树

        return verify(postorder, k, right - 1); // 检查右子树
    }

}
