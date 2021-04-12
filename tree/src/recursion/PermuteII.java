package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author sunxy
 * @date 2020/11/19 20:42
 */
@SuppressWarnings("unused")
public class PermuteII {

    private final List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> stack;
    private int[] visited;

    /*
        先升序排序，如果前、后两数相等。则跳过递归的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        stack = new Stack<>();
        int length = nums.length;
        Arrays.sort(nums);
        visited = new int[length];
        dfs(length, nums);
        return res;
    }

    private void dfs(int n, int[] nums) {
        if (stack.size() == n) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            visited[i] = 1;
            stack.add(nums[i]);
            dfs(n, nums);
            stack.pop();
            visited[i] = 0;
        }
    }

}
