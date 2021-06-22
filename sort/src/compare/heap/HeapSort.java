package compare.heap;

import compare.exchange.Exchange;

/**
 * 堆排序(排序结果递增)：
 * 1. 从输入数据构建大顶堆
 * 2. 此时，最大的元素在堆的根处。将其替换为堆的最后一项，然后将堆的大小减少1。最后，重新初始化堆结构
 * 3. 如果堆的大小不为1，则重复步骤2
 *
 * @author sunxy
 * @date 2020/9/27
 */
@SuppressWarnings("unused")
public class HeapSort {

    public void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            heapify(nums, len, i);
        }
            for (int i = len - 1; i > 0; i--) {
            Exchange.exchange(0, i, nums);
            heapify(nums, i, 0);
        }
    }

    public void heapify(int[] nums, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int root = i;
        if (left < length && nums[left] > nums[root]) root = left;
        if (right < length && nums[right] > nums[root]) root = right;
        if (root != i) {
            Exchange.exchange(root, i, nums);
            heapify(nums, length, root);
        }
    }

}
