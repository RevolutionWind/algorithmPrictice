package binarySearch;

/**
 * leetcode33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author walker
 * @date 2020-08-22
 */
@SuppressWarnings("unused")
public class SearchRotatingArr {


    /*
    二分法进阶版： 时间复杂度O(log(n))，空间复杂度O(1)
     */
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 获取中间值
            int mid = left + ((right - left) >> 1);
            // 终结条件
            if (nums[mid] == target) {
                return mid;
            }
            // 将数组模拟分成两组，左边为数组较大的递增组，右边为数值较小的递增组
            // 如果目标值大于数组的第一个元素，说明目标值应该在
            if (target >= nums[0]) {
                // 如果中间元素小于第一个元素，说明mid在右半段
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 目标值在右半段时，若 mid 在左半段，则将 mid 索引的值改成 -inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /*
    二分法:  时间复杂度O(log(n))，空间复杂度O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[right]) {
                // 左边有序
                if (target >= nums[left] && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (target <= nums[right] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatingArr s = new SearchRotatingArr();
        int search = s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }

}