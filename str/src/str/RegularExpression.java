package str;

import java.util.HashMap;
import java.util.Map;

/**
 * 10. 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * <p>
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * @author sunxy
 * @date 2021/4/16 20:33
 */
@SuppressWarnings("unused")
public class RegularExpression {

    /*
       递归
     */
    Map<String, Boolean> map = new HashMap<>();

    public boolean isMatch(String s, String p) {
        if (map.containsKey(s + "_" + p)) {
            return map.get(s + "_" + p);
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        boolean res;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            res = isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            res = firstMatch && isMatch(s.substring(1), p.substring(1));
        }
        map.put(s + "_" + p, res);
        return res;
    }

    /*
        dp
     */
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || firstMatch(s, p, i, j - 1) && dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = firstMatch(s, p, i, j) && dp[i][j];
                }
            }
        }
        return false;
    }

    private boolean firstMatch(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }

}
