package str.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * @author sunxy
 * @date 2021/4/24 20:08
 */
@SuppressWarnings("unused")
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        // 要匹配的子串map，窗口map
        Map<Character, Integer> need = new HashMap<>(s1.length()),
                window = new HashMap<>(s2.length());
        // 初始化need数组
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0));
        }
        // 左指针，右指针，符合need的s2子串长度
        int left = 0, right = 0, flag = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (window.get(c).equals(need.get(c))) {
                window.put(c, window.getOrDefault(c, 0));
                flag++;
            }
            // 判断左侧窗口是否需要收缩
            while (right - left == s1.length()) {
                if (flag == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                // 对左窗口进行一系列更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        flag--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

}
