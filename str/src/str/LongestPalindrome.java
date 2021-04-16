package str;

/**
 * 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *
 * @author sunxy
 * @date 2021/4/12 16:37
 */
@SuppressWarnings("unused")
public class LongestPalindrome {

    int lo, high;

    /*
        1. 中心扩展法
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) return s;
        for (int i = 0; i < len - 1; i++) {
            centerExpend(s, i, i, len);
            centerExpend(s, i, i + 1, len);
        }
        return s.substring(lo, high + 1);
    }

    private void centerExpend(String s, int c1, int c2, int len) {
        while (c1 >= 0 && c2 < len && s.charAt(c1) == s.charAt(c2)) {
            c1--;
            c2++;
        }
        if (c2 - c1 - 2 > high - lo) {
            lo = c1 + 1;
            high = c2 - 1;
        }
    }

    /*
        2. 动态规划
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) return s;
        // 回文串的起点和终点
        int lo = 0, high = -1;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (j - i > high - lo) {
                    lo = i;
                    high = j;
                }
            }
        }
        if (high < lo) return "";
        return s.substring(lo, high + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        System.out.println(obj.longestPalindrome1("cbbd"));
    }

}
