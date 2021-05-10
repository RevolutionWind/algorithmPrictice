package dp.coin;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 */
@SuppressWarnings("unused")
public class CoinChange {

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        dfs(coins, 0, 0, amount);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private void dfs(int[] coins, int count, int nowAmount, int amount) {
        // end
        if (nowAmount > amount) {
            return;
        }
        if (nowAmount == amount) {
            res = Math.min(res, count);
        }
        for (int coin : coins) {
            dfs(coins, count + 1, nowAmount + coin, amount);
        }
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
    }


}