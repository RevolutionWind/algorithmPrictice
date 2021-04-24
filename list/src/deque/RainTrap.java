package deque;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * @author sunxy
 * @date 2021/4/24 21:42
 */
@SuppressWarnings("unused")
public class RainTrap {
    /*
        暴力解法
     */
    public int trap1(int[] height) {
        int len = height.length;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < len; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    /*
        动态规划，存储元素左右的最大值
     */
    public int trap2(int[] height) {
        int len = height.length;
        // dp[i][0] 表示左边及i自身的最大值
        // dp[i][1] 表示右边及i自身的最大值
        int[][] dp = new int[len][2];
        dp[0][0] = height[0];
        dp[len - 1][1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.max(dp[i][0], dp[i][1]) - height[i];
        }
        return res;
    }

    public int trap3(int[] height) {
        return 0;
    }

}
