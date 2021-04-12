package str;

/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 *   如果剩余字符少于 k 个，则将剩余字符全部反转。
 *   如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * @author sunxy
 * @date 2021/4/2 20:18
 */
@SuppressWarnings("unused")
public class ReverseStrII {

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k > s.length()) {
                reverse(arr, i, s.length() - 1);
            } else {
                reverse(arr, i, i + k - 1);
            }
        }
        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int begin, int end) {
        while (begin < end) {
            char temp = arr[begin];
            arr[begin++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
