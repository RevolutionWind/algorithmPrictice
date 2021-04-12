package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 300. 最长递增子序列
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * @author sunxy
 * @date 2021/3/21 19:21
 */
@SuppressWarnings("unused")
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        List<Integer> cells = new ArrayList<>(len);
        cells.add(nums[0]);
        for (int i = 1; i < len; i++) {
            if (nums[i] > cells.get(cells.size() - 1)) {
                cells.add(nums[i]);
                continue;
            }
            int left = 0, right = cells.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (cells.get(mid) < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            cells.set(left, nums[i]);
        }
        return cells.size();
    }

    public static void main(String[] args) {
        LengthOfLIS ob = new LengthOfLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(ob.lengthOfLIS2(nums));
    }

}
