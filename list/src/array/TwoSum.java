package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 1. 暴力破解，双重for循环
 * 2. 用Hash表存储其中一个数，查找时时间复杂度为O(1)
 *
 * @author walker
 * @date 2020-07-29
 */
@SuppressWarnings("unused")
public class TwoSum {

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
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
//        int[] ints = twoSum.twoSum1(nums, target);
        int[] ints = twoSum.twoSum2(nums, target);
        Arrays.stream(ints).forEach(System.out::println);
    }

}