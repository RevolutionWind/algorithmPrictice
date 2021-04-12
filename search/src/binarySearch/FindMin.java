package binarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 *
 * @author sunxy
 * @date 2021/1/13 20:20
 */
@SuppressWarnings("unused")
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 二分法
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                // 如果mid的值大于right，则最小值在右边，移动左边
                left = mid + 1;
            } else {
                // 如果mid的值小于right，则最小值在左边，移动右边
                right = mid;
            }
        }
        return nums[left];
    }

}
