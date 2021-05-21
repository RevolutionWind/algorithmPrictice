/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * @author sunxy
 * @date 2021/5/21 8:48
 */
@SuppressWarnings("unused")
public class CuttingRope {


    int res = Integer.MIN_VALUE;

    /**
     * 记忆化搜索
     */
    public int cuttingRope(int n) {
        int[] memo = new int[n + 1];
        return cutting(n, memo);
    }

    private int cutting(int n, int[] memo) {
        if (n == 1) return 1;
        if (n < 1) return 0;
        if (memo[n] != 0) return memo[n];
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            res = Math.max(cutting(n - i, memo) * cutting(i, memo), res);
        }
        memo[n] = res;
        return res;
    }

    /*
        dp
    */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int res = Math.max(j * (i - j), j * dp[i - j]);
                max = Math.max(max, res);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /*
        贪心（取模之后的结果）
     */
    public int cuttingRope3(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        long res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
            res = res % 1000000007;
        }
        return (int) (res * n % 1000000007);
    }

}
