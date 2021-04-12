package binarySearch;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author walker
 * @date 2020/8/21
 */
@SuppressWarnings("unused")
public class MySqrt {

    /*
    二分法：
        时间复杂度： O(log(n))
        空间复杂度：因为是常数级，所以O(1)
     */
    public int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0, right = x, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /*
    牛顿迭代法
        时间复杂度： O(log(n))
        空间复杂度：因为是常数级，所以O(1)
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        System.out.println(m.mySqrt1(4));
    }

}
