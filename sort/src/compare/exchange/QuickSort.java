package compare.exchange;

/**
 * 快速排序：数组取标杆pivot，将小元素放pivot左边，大元素放到pivot右边，
 * 然后依次对右边和右边的子数组继续快排；以达到整个序列有序
 * <p>
 * 先调配出左右子数组，再对左右子数组进行排序
 *
 * @author sunxy
 * @date 2020/9/26
 */
@SuppressWarnings("unused")
public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = getPivot(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int getPivot(int[] nums, int begin, int end) {
        int pivot = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[i] < nums[end]) {
                Exchange.exchange(pivot, i, nums);
                pivot++;
            }
        }
        Exchange.exchange(pivot, end, nums);
        return pivot;
    }


}
