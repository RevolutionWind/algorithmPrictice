package str.slidingwindow;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * @author sunxy
 * @date 2021/4/23 17:19
 */
@SuppressWarnings("unused")
public class MinWindow {


    /*
        1. 初始化快、慢指针（left = right = 0）
        2. 先不断扩张right直到窗口中的所有字符串符合要求
        3. 符合要求后，再收缩left，直到不符合要求
        4. 重复2、3，直到right到字符串尽头
     */
    public String minWindow(String s, String t) {
        int len = s.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (char c :  t.toCharArray()) { // 记录 t 中所有字符出现的次数
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // 记录窗口中满足条件的字符个数
        int flag = 0;
        // 记录最小覆盖字串的起始索引及长度
        int start = 0, minLength = Integer.MAX_VALUE;

        while (right < len) {
            char c = s.charAt(right);
            // 判断取出的字符是否在 t 中
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                // 判断取出的字符在窗口中的出现次数是否与 t 中该字符的出现次数相同
                if (windowMap.get(c).equals(tMap.get(c))) {
                    flag++;
                }
            }
            // 判断是否需要缩小窗口(已经找到符合条件的子串)
            while (flag == tMap.size()) {
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                char d = s.charAt(left);
                left++;
                if (tMap.containsKey(d)) {
                    if (windowMap.get(d).equals(tMap.get(d))) {
                        flag--;
                    }
                    windowMap.put(d, windowMap.getOrDefault(d, 0) - 1);
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
