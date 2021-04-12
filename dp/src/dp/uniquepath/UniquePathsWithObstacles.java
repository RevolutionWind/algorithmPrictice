package dp.uniquepath;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @author sunxy
 * @date 2020/9/29
 */
@SuppressWarnings("unused")
public class UniquePathsWithObstacles {

    /*
    本题与寻找不同路径的题目大致相同，将终点作为起点，将起点作为终点。
        设置终点的值为1
        遍历每一行的元素，如果为1，则次点到终点的路径数为0.
        否则a[i][j] = a[i - 1][j] + a[i][j - 1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rolSize = obstacleGrid[0].length;
        int[] dp = new int[rolSize];
        dp[0] = 1;
        for (int[] ele : obstacleGrid) {
            for (int i = 0; i < rolSize; i++) {
                if (ele[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[rolSize - 1];
    }
}
