package dp.coin;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * @author sunxy
 * @date 2021/5/9 21:27
 */
@SuppressWarnings("unused")
public class CoinChangeWithDP {

    /*
    动态规划
        dp[i] 代表金额i所需的最小硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            // dp[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


}
