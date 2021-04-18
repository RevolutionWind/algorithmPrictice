package nsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author walker
 * @date 2020-07-29
 */
@SuppressWarnings("unused")
public class TwoSum {

    /*
        如果假设输入一个数组 nums 和一个目标和 target，
        请你返回 nums 中能够凑出 target 的两个元素的值，
        比如输入 nums = [5,3,1,6], target = 9，那么算法返回两个元素 [3,6]。
        可以假设只有且仅有一对儿元素可以凑出 target。
     */
    public void twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                System.out.println("res = [" + i + ", " + j + "]");
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("不存在");
    }

    /*
    爆破法
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /*
    hash
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
//        int[] ints = twoSum.twoSum1(nums, target);
        int[] ints = twoSum.twoSum2(nums, target);
        Arrays.stream(ints).forEach(System.out::println);
    }

}