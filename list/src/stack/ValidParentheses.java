package stack;

import java.util.Stack;

/**
 * leetcode20.有效的括号
 *
 * @author walker
 * @date 2020-08-04
 */
@SuppressWarnings("unused")
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (Character c : arr) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(s));

    }
}