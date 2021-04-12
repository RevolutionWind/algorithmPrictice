package dfs;

import java.util.*;

/**
 * leetcode102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author walker
 * @date 2020/8/19
 */
@SuppressWarnings("unused")
public class LevelOrder {

    /*
       BFS：
        第一层循环，循环树当前层的结点
        第二层循环，放入list中，并将自己弹出，将自己的子元素都推入队列

        时间复杂度： 每个点各进出一次，所以是O(n)
        空间复杂度： 队列中的元素最多有n个，所以是O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> visited = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 第一层循环
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            // 第二层循环
            while (size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (Objects.nonNull(poll.left)) {
                    queue.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    queue.add(poll.right);
                }
                size--;
            }
            visited.add(list);
        }
        return visited;
    }
}
