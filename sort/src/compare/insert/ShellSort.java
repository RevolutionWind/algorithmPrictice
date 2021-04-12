package compare.insert;

/**
 * 希尔排序: 第一个时间复杂度小于O(n^2)的排序。
 *
 * @author sunxy
 * @date 2020/9/26
 */
@SuppressWarnings("unused")
public class ShellSort {

    public void shellSort(int[] nums) {
        int len = nums.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int preIdx = i - gap, curVal = nums[i];
                while (preIdx >= 0 && nums[preIdx] > curVal) {
                    nums[preIdx + gap] = nums[preIdx];
                    preIdx -= gap;
                }
                nums[preIdx + gap] = curVal;
            }
        }
    }

}
