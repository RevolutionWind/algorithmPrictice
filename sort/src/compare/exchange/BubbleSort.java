package compare.exchange;

/**
 * 冒泡排序：遍历数组，比较每一个元素的大小。
 * 如果前面的元素比后面的小，则交换两个元素的位置
 *
 * @author walker
 * @date 2020/9/26
 */
@SuppressWarnings("unused")
public class BubbleSort {

    public void bubbleSort(int[] nums) {
        int len = nums.length;
        while (true) {
            boolean isExchange = false;
            for (int i = 1; i < len; i++) {
                if (nums[i] < nums[i - 1]) {
                    Exchange.exchange(i, i - 1, nums);
                    isExchange = true;
                }
            }
            if (!isExchange) break;
        }
    }

}
