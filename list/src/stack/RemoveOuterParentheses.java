package stack;

/**
 * leetcode1021.移除最外层的括号
 *
 * @author walker
 * @date 2020-08-04
 */
@SuppressWarnings("unused")
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (c == ')') {
                left--;
            }
            if (left > 0) {
                stringBuilder.append(c);
            }
            if (c == '(') {
                left--;
            }
        }
        return stringBuilder.toString();
    }
}