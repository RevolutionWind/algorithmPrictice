package dp.rob;

import dp.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * @author sunxy
 * @date 2021/6/29 21:07
 */
@SuppressWarnings("unused")
public class RobIII {

    Map<TreeNode, Integer> map = new HashMap<>();

    /*
        站在爷爷的角度考虑，要么偷儿子的，要么偷孙子的
        Math.max(偷儿子，偷孙子)
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) return map.get(root);
        int robSon = rob(root.left) + rob(root.right);

        int robGrand = root.val;
        if (root.left != null) {
            robGrand += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            robGrand += rob(root.right.left) + rob(root.right.right);
        }
        int res = Math.max(robSon, robGrand);
        map.put(root, res);
        return res;
    }

}
