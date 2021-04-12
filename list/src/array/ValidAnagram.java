package array;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 * @author walker
 * @date 2020-08-04
 */
@SuppressWarnings("unused")
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i])
                return false;
        }
        return true;
    }
}
