package array.topk;

import java.util.ArrayList;
import java.util.List;

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

    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>(n);
        int num = 1;
        while (list.size() < n) {
            if (num == 1 || num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                list.add(num);
            }
            num++;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        NthUglyNumber obj = new NthUglyNumber();
        System.out.println(obj.nthUglyNumber(11));
    }


}
