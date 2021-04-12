package binarySearch;

/**
 * leetcode367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False
 *
 * @author walker
 * @date 2020/8/21
 */
@SuppressWarnings("unused")
public class PerfectSquare {

    /*
       1.二分法查找
       时间复杂度： O(log(n))
       空间复杂度： O(1)
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            }
            if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
