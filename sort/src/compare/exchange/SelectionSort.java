package compare.exchange;

/**
 * 选择排序：一个数组，从未排序的部门中找到最小(大)值，放入已排序的数组中。
 *
 * @author walker
 * @date 2020/9/26
 */
@SuppressWarnings("unused")
public class SelectionSort {

    public void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int idx = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[idx]) {
                    idx = j;
                }
            }
            Exchange.exchange(idx, i, nums);
        }
    }
}
