package array.topk;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指Offer 40. 最小的k个数
 *
 * @author sunxy
 * @date 2021/5/1 9:33
 */
@SuppressWarnings("unused")
public class LeastNumbers {

    /*
        快排
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int len = arr.length;
        if (k == 0 || len == 0) {
            return new int[]{};
        }
        return quickSort(arr, 0, len - 1, k - 1);
    }

    private int[] quickSort(int[] nums, int start, int end, int k) {
        int pivot = getPivot(nums, start, end);
        if (pivot == k) {
            return Arrays.copyOf(nums, pivot + 1);
        }
        // 根据pivot与k的值比较，判断下次去左/右区间找
        return pivot > k ? quickSort(nums, start, pivot - 1, k) : quickSort(nums, pivot + 1, end, k);
    }

    private int getPivot(int[] nums, int start, int end) {
        int pivot = start;
        for (int i = pivot; i <= end; i++) {
            if (nums[i] < nums[end]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                pivot++;
            }
        }
        int temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return pivot;
    }

    /*
        定义大根堆
        保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
         1. 若目前堆的大小小于K，将当前数字放入堆中。
         2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
            反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

}
