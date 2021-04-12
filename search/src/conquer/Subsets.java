package conquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * nums = [1,2,3]
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author walker
 * @date 2020/8/17
 */
@SuppressWarnings("unused")
public class Subsets {

    /*
    1. 递归
     */
    public List<List<Integer>> subset1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        return recursion(nums, 0, res);
    }

    private List<List<Integer>> recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) {
            return res;
        }
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> list = new ArrayList<>(res.get(j));
            list.add(nums[i]);
            res.add(list);
        }
        return recursion(nums, i + 1, res);
    }

    /*
    2. 迭代
        循环遍历目标数组，将元素依次放入结果集中
        依次循环
     */
    public List<List<Integer>> subset2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    /*****************************************************************************/
    /*
    DFS
     */


    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subset = s.subset1(nums);
        System.out.println();
    }

}
