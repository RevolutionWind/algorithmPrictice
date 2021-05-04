package array.topk;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 264. 丑数 II
 * <p>
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 * @author sunxy
 * @date 2021/5/1 14:36
 */
@SuppressWarnings("unused")
public class NthUglyNumber {

    /*
        要得到从小到大的第 n 个丑数，可以使用最小堆实现。
        初始时堆为空。首先将最小的丑数 1 加入堆。
        每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x,3x,5x 也是丑数，
        因此将 2x,3x,5x 加入堆。
        上述做法会导致堆中出现重复元素的情况。为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
        在排除重复元素的情况下，第 n 次从最小堆中取出的元素即为第 n 个丑数。
     */
    public int nthUglyNumber1(int n) {
        if (n < 1) return -1;
        int[] ele = new int[]{2, 3, 5};
        Queue<Long> queue = new PriorityQueue<>(n);
        Set<Long> seen = new HashSet<>(n);
        queue.add(1L);
        seen.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long poll = queue.poll();
            ugly = (int) poll;
            for (int e : ele) {
                long next = poll * e;
                if (seen.add(next)) {
                    queue.add(next);
                }
            }
        }
        return ugly;
    }

    /*
        动态规划：
            小顶堆的方法是先存再排，dp 的方法则是先排再存
            我们设3个指针 p_2,p_3,p_5
            代表的是第几个数的2倍、第几个数 3 倍、第几个数 5 倍
            动态方程 dp[i] = min(dp[p_2]*2, dp[p_3]*3, dp[p_5]*5)
            小顶堆是一个元素出来然后存3个元素
            动态规划则是标识 3 个元素，通过比较他们的 2 倍、3 倍、5 倍的大小，来一个一个存
     */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = (int) 18322341344L;
        System.out.println(i);
    }

}
