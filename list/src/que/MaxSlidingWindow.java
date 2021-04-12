package que;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指offer59.滑动窗口的最大值
 *
 * @author walker
 * @date 2020-08-05
 */
@SuppressWarnings("unused")
public class MaxSlidingWindow {

    /*
    暴力解法
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int maxNum = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                maxNum = Math.max(maxNum, nums[j]);
            }
            res[resIndex++] = maxNum;
        }
        return res;
    }

    /*
    双指针：
        1. 第一个指针指向滑动窗口的最左边，第二个指针指向滑动窗口的最右边
          当有移动时，有新的元素进入窗口。
        2. 定义一个双端队列, 存放滑动窗口中的元素，最大值在最左边，向右递减
        3. 当滑动窗口进入新元素时，在队列中从右到左比较元素的大小，如果新元素比最右元素大，则弹出最右元素，直至新元素成为最右
        4. 当滑动窗口弹出旧元素时，要比较最左元素是否和旧元素相等，若相等，则弹出最左元素
     */
//    public int[] maxSlidingWindow2(int[] nums, int k) {
//        int len = nums.length;
//        int[] res = new int[len - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
////        for (int i = 0, j = 1 - k; )
//    }

    /*
    双指针
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.getFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 保持 deque 递减
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.getFirst();  // 记录窗口最大值
        }
        return res;
    }


    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = m.maxSlidingWindow1(nums, 3);
    }

}
