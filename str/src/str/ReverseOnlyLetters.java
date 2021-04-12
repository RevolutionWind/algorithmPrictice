package str;

import java.util.Stack;

/**
 * 917. 仅仅反转字母
 * <p>
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * @author sunxy
 * @date 2021/4/6 21:41
 */
@SuppressWarnings("unused")
public class ReverseOnlyLetters {

    /*
      用栈
     */
    public String reverseOnlyLetters1(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder(S.length());
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /*
      用双指针
     */
    public static String reverseOnlyLetters2(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }

}
