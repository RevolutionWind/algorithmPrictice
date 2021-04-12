package dp.maxprofit;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author sunxy
 * @date 2020/10/18
 */
@SuppressWarnings("unused")
public class MaxProfit1 {

    /*
    动态方程：
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        dp[i][1] = max(dp[i - 1][1], -prices[i])
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        // 一维：天数  二维：是否持有股票
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /*
        简化版
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_0 = Math.max(dp_0, dp_1 + price);
            dp_1 = Math.max(dp_1, -price);
        }
        return dp_0;
    }

}
