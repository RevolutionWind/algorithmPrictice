package array;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 题目数据保证答案肯定是一个 32 位的整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入："226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：s = "2"
 * 输出：1
 */
@SuppressWarnings("unused")
public class NumDecodings {

    /*
      dp中记录的是当前字符为止的解码方法
        1. 如果当前的数字等于1或2，结果+2
        2. 如果当前的数字大于2，结果+1
    */
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) return 0;
        // 存储解码到该字符共有几种解法
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) == '0') return 0;
            else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                if (s.charAt(i) == '0') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    dp[i + 1] = dp[i - 1] + dp[i];
                }
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("0"));
    }

}