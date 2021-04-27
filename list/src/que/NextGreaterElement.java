package que;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * <p>
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * @author sunxy
 * @date 2021/4/27 8:41
 */
@SuppressWarnings("unused")
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(len1);
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], i);
        }
        // 单调递减栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int idx = stack.pop();
                if (map.containsKey(nums2[idx])) {
                    res[map.get(nums2[idx])] = nums2[i];
                    map.remove(nums2[idx]);
                }
            }
            stack.add(i);
        }
        if (!map.isEmpty()) {
            for (Integer key : map.keySet()) {
                res[map.get(key)] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{5, 4, 3, 2, 1})));
    }

}
