package conquer;

/**
 * leetcode 50
 * 计算 x 的 n 次幂函数
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * @author walker
 * @date 2020/8/17
 */
@SuppressWarnings("unused")
public class Pow {

    /*
    1. 暴力破解
    超出时间限制
    时间复杂度： O(n^2)
    空间复杂度： O(n)
     */
    public double myPow1(double x, int n) {
        if (n < 0) {
            return myPow1(1 / x, n);
        }
        if (n == 0) return 1;
        double sum = x;
        for (int i = 1; i < n; i++) {
            sum = sum * x;
        }
        return sum;
    }

    /*
    2. 递归
·      （1） 终止条件，判断n是否为0，如果为0，则直接返回1
       （2） n/2作为n，下探到下一层，返回结果res
       （3） 判断当前是否为奇数，如果是，则返回res * res * x, 否则返回res * res
            时间复杂度： O(log(n))
            空间复杂度： O(log(n))
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            return recursion(1 / x, -n);
        }
        return recursion(x, n);
    }

    private double recursion(double x, int n) {
        // 终止条件
        if (n == 0) {
            return 1.0;
        }
        // 处理当前逻辑
        double res = recursion(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

    /*
    快速幂 + 迭代
        时间复杂度： O(log(n))
        空间复杂度： O(log(n))
     */
    public double myPow3(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        double v = pow.myPow3(3, 3);
        System.out.println(v);
    }
}
