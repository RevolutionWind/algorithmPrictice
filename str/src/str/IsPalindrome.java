package str;

/**
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author sunxy
 * @date 2021/4/11 10:00
 */
@SuppressWarnings("unused")
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[right])) {
                right--;
                continue;
            }
            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
