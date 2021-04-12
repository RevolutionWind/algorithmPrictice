package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author sunxy
 * @date 2020-11-16
 */
@SuppressWarnings("unused")
public class Combine {

    private List<List<Integer>> res;
    private Stack<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new Stack<>();
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int begin) {
        // end
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            // 遍历前的操作
            path.add(i);
            // 递归. 因为不能有重复的元素，所以begin要+1
            dfs(n, k, i + 1);
            // 回退
            path.pop();
        }
    }

}
