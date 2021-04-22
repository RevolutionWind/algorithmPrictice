package binarySearch;

/**
 * 二分搜索模板
 *
 * @author sunxy
 * @date 2021/4/21 16:11
 */
@SuppressWarnings("unused")
public class BinarySearchTemplate {

    /*
        闭区间，二分查找
     */
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 没找到
        return -1;
    }

    /*
        确认目标值的左边界
     */
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回, 确定左边界
                right = mid - 1;
            }
        }
        // 判断数组是否越界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /*
        确认目标值的右边界
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                // 别返回, 确定右边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

}
