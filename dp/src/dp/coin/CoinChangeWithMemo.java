package dp.coin;

/**
 * 322. 零钱兑换
 * <p>
 * 记忆化搜索
 *
 * @author sunxy
 * @date 2021/5/9 20:57
 */
@SuppressWarnings("unused")
public class CoinChangeWithMemo {

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];

        return findWay(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = findWay(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
    }

    public static void main(String[] args) {
        CoinChangeWithMemo c = new CoinChangeWithMemo();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
    }

}
