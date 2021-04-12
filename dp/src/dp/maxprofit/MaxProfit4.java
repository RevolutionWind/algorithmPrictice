package dp.maxprofit;

import java.util.stream.IntStream;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * @author sunxy
 * @date 2020/10/20
 */
@SuppressWarnings("unused")
public class MaxProfit4 {

    /*
    三维数组：超出内存限制
    len为数组长度
       因为买入和卖出两次操作为一笔交易，所以交易数k如果大于 len/2,则可以认为交易不限制笔数。
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        if (k > len / 2) return maxProfitUnlimited(prices);
        // 定义dp数组，一维: 交易的天数，二维: 交易的次数，三维是否持有股票(1持有，0未持有)
        int[][][] dp = new int[len][k + 1][2];
        // 初始化天数为0的情况
        for (int i = 1; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0; j--) {
                // 处理第k次卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 处理第k次买入
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    /*
    二维数组，交易笔数和当天是否持有
     */
    public int maxProfit2(int k, int[] prices) {
        int len = prices.length;
        if (k > (len >> 1)) return maxProfitUnlimited(prices);
        int[][] dp = new int[k + 1][2];
        IntStream.rangeClosed(1, k).forEach(i -> dp[i][1] = -prices[0]);
        for (int price : prices) {
            for (int j = k; j >= 1; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + price);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
            }
        }
        return dp[k][0];
    }


    /*
    不限次数的交易
     */
    private int maxProfitUnlimited(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
