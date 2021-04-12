package dp.uniquepath;

/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * @author sunxy
 * @date 2020/9/29
 */
@SuppressWarnings("unused")
public class UniquePaths {

    /*
    递归方式，超时
     */
    public int uniquePaths1(int m, int n) {
        int[][] arr = new int[m][n];
        arr[m - 1][n - 1] = 1;
        return findRoad(arr, 0, 0, m, n);
    }

    int findRoad(int[][] arr, int row, int col, int m, int n) {
        if (row == m || col == n) {
            return 0;
        }
        if (arr[row][col] == 1) {
            return 1;
        }
        return findRoad(arr, row + 1, col, m, n) + findRoad(arr, row, col + 1, m, n);
    }

    /*
    二维数组的方法
      1. 初始化二维数组，看作机器人的路径方格，把终点看作起点，把起点看作终点
      2. a[i][j]到终点的路径数 = a[i - 1][j]的路径数 + a[i][j - 1]的路径数
      3. 如果是终点所处于的列，则只能往下走，所以只有1种走法。
         如果是终点所处于的行，则只能往右走，所以只有1种走法。
     */
    public int uniquePaths2(int m, int n) {
        // 初始化dp数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /*
    由于二维数组的算法时间复杂度一定为O(m * n)，二维数组中每一个元素一定会算一次，
    现在的空间复杂度为O(m * n)
    所以可以只用一个数组表示行，优化一下空间复杂度为O(n)
     */
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }


}
