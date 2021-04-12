package compare.merge;

/**
 * 归并排序——分治
 * 1. 把长度为n的输入序列分成两个n/2的子序列
 * 2. 对这两个子序列分别采用归并排序
 * 3. 将两个排序好的子序列合并成一个最终的排序序列
 * <p>
 * 先排序左右，再合并
 *
 * @author sunxy
 * @date 2020/9/26
 */
@SuppressWarnings("unused")
public class MergeSort {

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeTwoArr(nums, left, mid, right);
    }

    private void mergeTwoArr(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int idx = 0; idx < temp.length; idx++) {
            nums[idx + left] = temp[idx];
        }
    }

}
