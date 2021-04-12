package recursion;

import java.util.*;

/**
 * 46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author sunxy
 * @date 2020/11/17 20:51
 */
@SuppressWarnings("unused")
public class Permute {

    private final List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        Stack<Integer> path = new Stack<>();
        backtrace(nums, path);
        return res;
    }

    /*
        路径：记录在path中
        选择列表：nums中不存在于path中的那些元素
        结束条件：nums中的元素全都在path中出现
     */
    void backtrace(int[] nums, Stack<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.add(num);
            backtrace(nums, path);
            path.pop();
        }
    }


}
