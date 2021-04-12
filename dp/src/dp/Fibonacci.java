package dp;

/**
 * 斐波那契动态规划解法:
 * 1. 递归代码: return n <= 1 ? n : fib(n - 1) + fib(n - 2)
 * 2. 增加一个数组，存储相同结点的结果。减少相同结点的遍历
 *
 * @author sunxy
 * @date 2020/9/27
 */
@SuppressWarnings("unused")
public class Fibonacci {

    /*
    递归方式
     */
    public int fib1(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] == 0) {
            memo[n] = fib1(n - 1, memo) + fib1(n - 2, memo);
        }
        return memo[n];
    }

    /*
    循环方式
     */
    public int fib2(int n) {
        int[] res = new int[n + 1];
        res[0] = 0; res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
        /*
        优化版，可以不用新建数组
         */
//        if (n < 3) return n;
//        int i = 0, j = 1, k = 2;
//        for (int m = 3; m <= n; m++) {
//            i = j;
//            j = k;
//            k = i + j;
//        }
//        return k;
    }

}
