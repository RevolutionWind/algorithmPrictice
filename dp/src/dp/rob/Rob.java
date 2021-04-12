package dp.rob;

/**
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
@SuppressWarnings("unused")
public class Rob {

    /*
    二维数组
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        dp[i][1] = dp[i - 1][0] + nums[i - 1];
     */
    public int rob1(int[] nums) {
        int len = nums.length;
        if (len < 2) return len == 1 ? nums[0] : 0;
        // 初始化dp数组，屋子，是否盗窃
        int[][] dp = new int[len][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    /*
    一维数组
        dp[i] = max(dp[i - 1], dp[i - 2] + num[i])
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 1 ? nums[0] : 0;
        // 初始化数组，屋子
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    /*
    最终版本：两个变量
        dp[i] = max(dp[i - 1], dp[i - 2] + num[i])
     */
    public int rob3(int[] nums) {
        int pre = 0, now = 0;
        for (int num : nums) {
            int temp = pre;
            pre = now;
            now = Math.max(temp + num, now);
        }
        return now;
    }

}