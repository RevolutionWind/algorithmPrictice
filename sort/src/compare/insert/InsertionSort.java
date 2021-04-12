package compare.insert;

/**
 * 插入排序： 就是构建有序数组。
 * 将第一个元素看作是一个有序的数组。再将从后面数组中不断取出值
 * 只要取出的数值小于(大于)有序数组的值，就向前挪动，直到找到取出的值大于(小于)该数组值的元素，就停止
 *
 * @author walker
 * @date 2020/9/26
 */
@SuppressWarnings("unused")
public class InsertionSort {

    public void insertionSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int preIdx = i - 1, curVal = nums[i];
            while (preIdx >= 0 && nums[preIdx] > curVal) {
                nums[preIdx + 1] = nums[preIdx];
                preIdx--;
            }
            nums[preIdx + 1] = curVal;
        }
    }
}
