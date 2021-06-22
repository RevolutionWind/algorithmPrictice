package binarySearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author sunxy
 * @date 2021/6/18 17:04
 */
@SuppressWarnings("unused")
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        int len = nums.length;
        if (len < 1) return range;
        int left = 0, right = len - 1;
        // 找到最后一个小于target的值
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int lastLessThanTarget = right;
        // 找到第一个大于target的值
        left = 0;
        right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int firstMoreThanTarget = right + 1;

        if (lastLessThanTarget == len - 1 || nums[lastLessThanTarget + 1] != target) {
            return range;
        } else {
            range[0] = lastLessThanTarget + 1;
        }
        if (firstMoreThanTarget == 0 || nums[firstMoreThanTarget - 1] != target) {
            return range;
        } else {
            range[1] = firstMoreThanTarget - 1;
        }

        return range;
    }

}
