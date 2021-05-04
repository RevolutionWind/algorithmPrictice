package que;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author sunxy
 * @date 2021/4/26 20:54
 */
@SuppressWarnings("unused")
public class LargestRectangleArea {

    /*
        暴力解
            遍历每个柱子
                找出左边第一个比它大的，和右边第一个比它大的，求长度
                max(左边的面积, 右边的面积)
    */
    public int largestRectangleArea(int[] heights) {
        int res = 0, len = heights.length;
        for (int i = 0; i < len; i++) {
            // 左边第一个比它小的数
            int left = i, right = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < len - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            res = Math.max(res, (right - left + 1) * heights[i]);
        }
        return res;
    }

    /*
        单调栈：
            因为要找当前柱子左边第一个比它小的，和右边第一个比它小的
            所以维护一个单调递增栈
            如果当前栈顶元素大于当前柱子，则栈顶元素就找到了左边第一个比它小的和右边第一个比它小的
     */
    public int largestRectangleArea2(int[] heights) {
        int res = 0, len = heights.length;
        int[] temp = new int[len + 2];
        // 如果这个数组所有元素都相等，就不会执行单调栈的逻辑
        // 所以要在前后加上0元素
        for (int i = 1; i < len + 1; i++) {
            temp[i] = heights[i - 1];
        }
        // 存的数组下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len + 2; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                Integer idx = stack.pop();
                res = Math.max(res, temp[idx] * (i - stack.peek() - 1));
            }
            stack.add(i);
        }
        return res;
    }


}
