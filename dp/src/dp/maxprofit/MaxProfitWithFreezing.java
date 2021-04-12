package dp.maxprofit;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author sunxy
 * @date 2020/10/20
 */
@SuppressWarnings("unused")
public class MaxProfitWithFreezing {

    /*
    动态方程:
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + price[i])
        dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - price[i])
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /*
    简化版
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE, pre = 0;
        for (int price : prices) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + price);
            dp_1 = Math.max(dp_1, pre - price);
            pre = temp;
        }
        return dp_0;
    }

}
