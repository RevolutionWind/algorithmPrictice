package str;

/**
 * 反转字符串II
 *
 * @author sunxy
 * @date 2020/9/28
 */
@SuppressWarnings("unused")
public class ReverseStr {
    /*
    反转字符串
     */
    public String reverseStr(String s, int k) {
        char[] char_array = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i, end = Math.min(i + k - 1, s.length() - 1);
            while (start < end) {
                char tmp = char_array[start];
                char_array[start++] = char_array[end];
                char_array[end--] = tmp;
            }
        }

        return new String(char_array);
    }
}
