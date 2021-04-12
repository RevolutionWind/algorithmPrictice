package greedy;

/**
 * leetcode122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 * @author walker
 * @date 2020/8/20
 */
@SuppressWarnings("unused")
public class MaxProfitII {

    /*
    贪心算法
     */
    public int maxProfit1(int[] prices) {
        // 总利润
        int profit = 0;
        // 数组下标
        int index = 0;
        // 当前购买
        while (index < prices.length) {
            if (prices[index] < prices[index + 1]) {
                profit += prices[index + 1] - prices[index];
            }
            index++;
        }
        return profit;
    }

}
