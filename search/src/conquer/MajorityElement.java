package conquer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * leetcode169.多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入：[3,2,3]
 * 返回：3
 *
 * @author sunxy
 * @date 2020/8/18
 */
@SuppressWarnings("unused")
public class MajorityElement {

    /*
     hash算法:
      (1) 将数值作为key，数值在数组中出现的次数作为value，得到HashMap
      (2) 取得map的value中的最大值max
      (3) 遍历循环Map中的Entry集合，找到与max相等的value，并返回对应的key

        时间复杂度： 其中 n 是数组 nums 的长度。我们遍历数组 nums 一次，对于 nums 中的每一个元素，将其插入哈希表都只需要常数时间。
                   如果在遍历时没有维护最大值，在遍历结束后还需要对哈希表进行遍历，
                   因为哈希表中占用的空间为 O(n)（可参考下文的空间复杂度分析），那么遍历的时间不会超过 O(n)。
                   因此总时间复杂度为 O(n)
        空间复杂度： 哈希表最多包含（n-n/2）个键值对
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        Integer maxCount = map.values().stream().max(Comparator.comparingInt(v -> v)).orElse(Integer.MIN_VALUE);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount.equals(entry.getValue()))
                return entry.getKey();
        }
        throw new IllegalArgumentException("非法参数");
    }

    /*
      直接排序返回中间数
      时间复杂度： O(log(n))
      空间复杂度： O(1)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    流
      时间复杂度： 因为开始的分组流和后来的寻找最大值的最坏情况将数组遍历了1.5遍，所以时间复杂度为O(n)
      空间复杂度： 哈希表最多包含（n-n/2）个键值对，O(n)
     */
    public int majorityElement4(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }

    /**************************************************************************************************************************/
    /*
    分治法
       时间复杂度： 二分 + 每次扫描都会扫描两边的n/2个元素，所以时间复杂度为O(nlog(n))
       空间复杂度： 没有用到额外的空间，但是递归时会占用系统的调用栈的空间，所以空间复杂度为O(log(n))
     */
    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
