package dp;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * @author sunxy
 * @date 2020/10/4
 */
@SuppressWarnings("unused")
public class MinimumTotal {
    /*
    二维数组
        将三角形的最小路径和都保存起来
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        // 定义二维数组
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            List<Integer> ele = triangle.get(i);
            for (int j = 0; j < ele.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + ele.get(j);
            }
        }
        return dp[0][0];
    }

    /*
    一维数组
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int triangleSize = triangle.size();
        int maxColSize = triangle.get(triangleSize - 1).size();
        int[] dp = new int[maxColSize + 1];
        for (int i = triangleSize - 1; i >= 0; i--) {
            List<Integer> ele = triangle.get(i);
            for (int j = 0; j < ele.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + ele.get(j);
            }
        }
        return dp[0];
    }
}
