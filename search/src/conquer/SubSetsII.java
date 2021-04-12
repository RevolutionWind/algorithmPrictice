package conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * @author sunxy
 * @date 2020/11/25 19:54
 */
@SuppressWarnings("unused")
public class SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 1) return res;
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, len, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path,
                           int len, int[] nums, int idx) {
        // end
        res.add(new ArrayList<>(path));
        if (path.size() == len) return;
        for (int i = idx; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(res, path, len, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
